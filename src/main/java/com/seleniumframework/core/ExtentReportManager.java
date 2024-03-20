package com.seleniumframework.core;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class ExtentReportManager {
    public static ExtentReports extentReports;


    /**
     * @param fileName
     * @param reportName
     * @param documentTitle
     * @return ExtentReports
     */
    public static ExtentReports createInstance(String fileName, String reportName, String documentTitle) {
        ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter(fileName);
        extentSparkReporter.config().setTheme(Theme.DARK);
        extentSparkReporter.config().setReportName(reportName);
        extentSparkReporter.config().setDocumentTitle(documentTitle);
        extentSparkReporter.config().setEncoding("utf-8");
        extentReports = new ExtentReports();
        extentReports.attachReporter(extentSparkReporter);
        return extentReports;
    }

    /**
     * @return String
     */
    public static String getReportNameWithTimeStamp() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm_ss");
        LocalDateTime localDateTime = LocalDateTime.now();
        String datetime = "Report_"+dateTimeFormatter.format(localDateTime);
        return "reports/extent/" +datetime + ".html";
    }

    /**
     * @param log
     */
    public static void logPassDetails(String log) {
        TestListener.extentTest.get().pass(MarkupHelper.createLabel(log, ExtentColor.GREEN));
    }

    /**
     * @param log
     */
    public static void logFailDetails(String log) {
        TestListener.extentTest.get().fail(MarkupHelper.createLabel(log, ExtentColor.RED));
    }

    /**
     * @param log
     */
    public static void logStacktrace(String log) {
        String trace = log.replaceAll(",", "<br>");
        String finalStracktrace = "<details>/n" +
                "<summary>Click here to view the Exception stackTrace</summary>/n" +
                trace + "</details>/n";
        TestListener.extentTest.get().fail(finalStracktrace);
    }

    /**
     * @param log
     */
    public static void logSkippedDetails(String log) {
        TestListener.extentTest.get().skip(MarkupHelper.createLabel(log, ExtentColor.YELLOW));
    }

    /**
     * @param log
     */
    public static void logWarningDetails(String log) {
        TestListener.extentTest.get().warning(MarkupHelper.createLabel(log, ExtentColor.BLUE));
    }

    /**
     * @param log
     */
    public static void logInfoDetails(String log) {
        TestListener.extentTest.get().info(MarkupHelper.createLabel(log, ExtentColor.ORANGE));
    }
    public static void logAttachScreenshot(String screenShot){
        TestListener.extentTest.get().info(MediaEntityBuilder.createScreenCaptureFromBase64String(screenShot).build());
    }

    /**
     * @param json
     */
    public static void logJson(String json){
        TestListener.extentTest.get().info(MarkupHelper.createCodeBlock(json, CodeLanguage.JSON));
    }

    /**
     * @param xml
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
