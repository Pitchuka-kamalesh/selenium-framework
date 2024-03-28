package com.seleniumframework.core;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.Arrays;
/**
 * TestNG listener implementation for handling test execution events.
 * @author Kamalesh
 * @version 1.0
 */
public class TestListener implements ITestListener {
    private static final Logger log = LogManager.getLogger(TestListener.class.getName());
    public static final ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();
    private ExtentReports extentReport;
    /**
     * Invoked when a test method starts execution.
     *
     * @param result The test result representing the test method being executed.
     */
    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest test = extentReport.createTest("TestName  :" + result.getMethod().getMethodName());
        extentTest.set(test);

    }

    /**
     * Invoked when a test method fails.
     *
     * @param result The test result representing the failed test method.
     */

    @Override
    public void onTestFailure(ITestResult result) {
        log.info("Capture the screenshot in the Report");
        ExtentReportManager.logAttachScreenshot(TestUtils.takeScreenshotAsBase64(DriverManager.getDriver()));
        log.error(result.getThrowable().getMessage());
        ExtentReportManager.logFailDetails(result.getThrowable().getMessage());
        ExtentReportManager.logStacktrace(result.getThrowable().fillInStackTrace());

    }
    /**
     * Invoked before any test method belonging to the classes inside the &lt;test&gt; tag is run.
     *
     * @param context The test context representing the test class being executed.
     */
    @Override
    public void onStart(ITestContext context) {
        extentReport = ExtentReportManager.createInstance(PropertiesUtils.getProperties().getProperty("report_path"), "Testing E2E", "Extent Report");
        TestUtils.launchApp();
    }
    /**
     * Invoked after all the test methods belonging to the classes inside the &lt;test&gt; tag have run.
     *
     * @param context The test context representing the test class being executed.
     */
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
