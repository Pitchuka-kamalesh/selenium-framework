package com.seleniumframework.core;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.Arrays;

public class TestListener implements ITestListener {
    public static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();
    private static ExtentReports extentReport;

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest test = extentReport.createTest("TestName  :" + result.getMethod().getMethodName());
        extentTest.set(test);

    }

    @Override
    public void onTestSuccess(ITestResult result) {

    }

    @Override
    public void onTestFailure(ITestResult result) {
        ExtentReportManager.logFailDetails(result.getThrowable().getMessage());
        ExtentReportManager.logStacktrace(Arrays.toString(result.getThrowable().getStackTrace()));

    }

    @Override
    public void onTestSkipped(ITestResult result) {


    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {
        extentReport = ExtentReportManager.createInstance(ExtentReportManager.getReportNameWithTimeStamp(), "TestApiAutomaction", "Api Testing");
        String browserName = context.getCurrentXmlTest().getParameter("browserName");
        if(browserName==null){
            ExtentReportManager.logInfoDetails("Browsername is not present");

        }
        else {
            ExtentReportManager.logInfoDetails("BrowserName  "+browserName);
            WebDriver driver = DriverFactory.getDriver(browserName);
            DriverManager.setDriver(driver);
        }


    }

    @Override
    public void onFinish(ITestContext context) {
        DriverManager.closeWebDriver();
        if (extentReport != null) {
            extentReport.flush();
        }

    }

    // i have to implements all the common reports and logging and retry mech
}
