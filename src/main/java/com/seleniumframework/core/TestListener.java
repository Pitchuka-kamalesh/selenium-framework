package com.seleniumframework.core;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.Arrays;

public class TestListener implements ITestListener {
    private static final Logger log = LogManager.getLogger(TestListener.class.getName());
    public static final ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();
    private ExtentReports extentReport;

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest test = extentReport.createTest("TestName  :" + result.getMethod().getMethodName());
        extentTest.set(test);

    }


    @Override
    public void onTestFailure(ITestResult result) {
        log.info("Capture the screenshot in the Report");
        ExtentReportManager.logAttachScreenshot(TestUtils.takeScreenshotAsBase64(DriverManager.getDriver()));
        log.error(result.getThrowable().getMessage());
        ExtentReportManager.logFailDetails(result.getThrowable().getMessage());
        log.error(result.getThrowable().getStackTrace());
        ExtentReportManager.logStacktrace(Arrays.toString(result.getThrowable().getStackTrace()));

    }

    @Override
    public void onStart(ITestContext context) {
        extentReport = ExtentReportManager.createInstance(ExtentReportManager.getReportNameWithTimeStamp(), "TestApiAutomaction", "Api Testing");
        TestUtils.launchApp();
    }

    @Override
    public void onFinish(ITestContext context) {
        log.info("TestListener.onFinish()");
        DriverManager.closeWebDriver();
        DriverManager.releaseDriver();
        if (extentReport != null) {
            log.info("TestListener.onFinish() -> closing the reports");
            extentReport.flush();
        }

    }

    // i have to implements all the common reports and logging and retry mech
}
