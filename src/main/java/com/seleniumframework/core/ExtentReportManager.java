package com.seleniumframework.core;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
/**
 * Manages ExtentReports for test reporting.
 *
 * @see com.seleniumframework.core.TestListener
 * @author Kamalesh
 * @version 1.0
 */

public class ExtentReportManager {
    public static ExtentReports extentReports = new ExtentReports();


    /**
     * Creates an instance of ExtentReports.
     * @param fileName The file name for the report.
     * @param reportName The name of the report.
     * @param documentTitle The title of the document.
     * @return An instance of ExtentReports.
     */
    public static ExtentReports createInstance(String fileName, String reportName, String documentTitle) {
        ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter(fileName);
        extentSparkReporter.config().setTheme(Theme.DARK);
        extentSparkReporter.config().setReportName(reportName);
        extentSparkReporter.config().setDocumentTitle(documentTitle);
        extentSparkReporter.config().setEncoding("utf-8");
        extentReports.attachReporter(extentSparkReporter);
        return extentReports;
    }

    /**
     * Generates a report name with a timestamp.
     * @return A report name with a timestamp.
     */
    public static String getReportNameWithTimeStamp() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm_ss");
        LocalDateTime localDateTime = LocalDateTime.now();
        String datetime = "Report_"+dateTimeFormatter.format(localDateTime);
        return "reports/extent/" +datetime + ".html";
    }

    /**
     * Logs a pass message in the Extent Report.
     *
     * @param log The log message to be displayed.
     */
    public static void logPassDetails(String log) {
        TestListener.extentTest.get().pass(MarkupHelper.createLabel(log, ExtentColor.GREEN));
    }

    /**
     * Logs a fail message in the Extent Report.
     *
     * @param log The log message to be displayed.
     */
    public static void logFailDetails(String log) {
        TestListener.extentTest.get().fail(MarkupHelper.createLabel(log, ExtentColor.TRANSPARENT));
    }

    /**
     * Logs a stack trace in the Extent Report.
     *
     * @param log The log message containing the stack trace.
     */
    public static void logStacktrace(Throwable log) {
        TestListener.extentTest.get().log(Status.FAIL,log);
    }

    /**
     * Logs a skipped message in the Extent Report.
     *
     * @param log The log message to be displayed.
     */
    public static void logSkippedDetails(String log) {
        TestListener.extentTest.get().skip(MarkupHelper.createLabel(log, ExtentColor.YELLOW));
    }

    /**
     * Logs a warning message in the Extent Report.
     *
     * @param log The log message to be displayed.
     */
    public static void logWarningDetails(String log) {
        TestListener.extentTest.get().warning(MarkupHelper.createLabel(log, ExtentColor.BLUE));
    }

    /**
     * Logs an information message in the Extent Report.
     *
     * @param log The log message to be displayed.
     */
    public static void logInfoDetails(String log) {
        TestListener.extentTest.get().info(MarkupHelper.createLabel(log, ExtentColor.ORANGE));
    }
    /**
     * Logs a screenshot in the Extent Report.
     *
     * @param screenShot The base64 encoded string of the screenshot.
     */
    public static void logAttachScreenshot(String screenShot){
        TestListener.extentTest.get().addScreenCaptureFromBase64String(screenShot,"FailureScreenshot").assignCategory("screenshots");
        TestListener.extentTest.get().info("FailureScreenShot",MediaEntityBuilder.createScreenCaptureFromBase64String(screenShot).build());
    }

    /**
     * Logs a JSON content in the Extent Report.
     *
     * @param json The JSON content to be displayed.
     */
    public static void logJson(String json){
        TestListener.extentTest.get().info(MarkupHelper.createCodeBlock(json, CodeLanguage.JSON));
    }
    /**
     * Logs an XML content in the Extent Report.
     *
     * @param xml The XML content to be displayed.
     */
    public static void logXMLBody(String xml){
        TestListener.extentTest.get().info(MarkupHelper.createCodeBlock(xml,CodeLanguage.XML));
    }

 /*
    This is for the Api reporting.


    public static  void  logHeaders(List<Header> headersList){
        String[][] arrayHeaders = headersList.stream().map(header -> new String[] {header.getName(), header.getValue()}).toArray(String[][] :: new);
        TestListener.extentTest.get().info(MarkupHelper.createTable(arrayHeaders));

    }

    public static void printRequestLogInReport(RequestSpecification requestSpecification) {
        QueryableRequestSpecification queryableRequestSpecification = SpecificationQuerier.query(requestSpecification);
        ExtentReportManager.logInfoDetails("Endpoint is " + queryableRequestSpecification.getURI());
        ExtentReportManager.logInfoDetails("Method is " + queryableRequestSpecification.getMethod());
        ExtentReportManager.logInfoDetails("Headers are ");
        ExtentReportManager.logHeaders(queryableRequestSpecification.getHeaders().asList());
        ExtentReportManager.logInfoDetails("Request body is ");
        ExtentReportManager.logJson(queryableRequestSpecification.getBody());
    }

    public static void printResponseLogInReport(Response response) {
        ExtentReportManager.logInfoDetails("Response status is " + response.getStatusCode());
        ExtentReportManager.logInfoDetails("Response Headers are ");
        ExtentReportManager.logHeaders(response.getHeaders().asList());
        ExtentReportManager.logInfoDetails("Response body is ");
        ExtentReportManager.logJson(response.getBody().prettyPrint());
    }*/


}
