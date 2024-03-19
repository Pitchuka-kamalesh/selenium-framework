package com.seleniumframework.core;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.support.ThreadGuard;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.Arrays;

public class TestListener implements ITestListener {
    public static final ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();
    private ExtentReports extentReport;

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest test = extentReport.createTest("TestName  :" + result.getMethod().getMethodName());
        extentTest.set(test);

    }


    @Override
    public void onTestFailure(ITestResult result) {
        ExtentReportManager.logFailDetails(result.getThrowable().getMessage());
        ExtentReportManager.logStacktrace(Arrays.toString(result.getThrowable().getStackTrace()));

    }

    @Override
    public void onStart(ITestContext context) {
        extentReport = ExtentReportManager.createInstance(ExtentReportManager.getReportNameWithTimeStamp(), "TestApiAutomaction", "Api Testing");
        String browser = context.getCurrentXmlTest().getParameter("browserName");
        DriverManager.setDriver(ThreadGuard.protect(DriverFactory.getBrowserDriver(browser)));

    }

    @Override
    public void onFinish(ITestContext context) {
        DriverManager.closeWebDriver();
        DriverManager.releaseWebDriver();
        if (extentReport != null) {
            extentReport.flush();
        }

    }

    // i have to implements all the common reports and logging and retry mech
}
