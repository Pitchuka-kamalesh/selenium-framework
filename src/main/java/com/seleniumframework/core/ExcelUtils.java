package com.seleniumframework.core;

import org.apache.poi.ss.usermodel.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

/**
 * Utility class for working with Excel files.
 * @author Kamalesh
 * @version 1.0
 */
public class ExcelUtils {
    static Workbook workbook;
    static Sheet sheet;

    /**
     * Loads the Excel workbook from the specified file path.
     *
     * @param excelFilePath The file path of the Excel workbook to load.
     * @throws IOException If the specified file path is not found or any IOException occurs.
     */
    public static void loadWorkbook(String excelFilePath) throws IOException {
        try (FileInputStream fi = new FileInputStream(new File(excelFilePath))) {
            workbook = WorkbookFactory.create(fi);
        } catch (IOException io) {
            io.getStackTrace();
        }

    }

    /**
     * Gets the number of rows in the specified sheet.
     *
     * @param sheetName The name of the sheet.
     * @return The number of rows in the sheet.
     */
    public static int getRowCount(String sheetName) {
        Sheet sheet = workbook.getSheet(sheetName);
        return sheet.getLastRowNum();
    }

    /**
     * Gets the number of cells in the first row of the specified sheet.
     *
     * @param sheetName The name of the sheet.
     * @return The number of cells in the first row of the sheet.
     */
    public static int getCellCount(String sheetName) {
        Sheet sheet = workbook.getSheet(sheetName);
        return sheet.getRow(0).getLastCellNum();
    }

    /**
     * Gets the value of the cell at the specified row and column in the specified sheet.
     *
     * @param sheetName The name of the sheet.
     * @param rowNum    The row number.
     * @param cellNum   The column number.
     * @return The value of the cell as a string.
     */
    public static String getCellData(String sheetName, int rowNum, int cellNum) {
        String cellValue = null;
        Sheet sheet = workbook.getSheet(sheetName);
        Cell cell = sheet.getRow(rowNum).getCell(cellNum);
        if (cell.getCellType() == CellType.NUMERIC) {
            cellValue = String.valueOf(cell.getNumericCellValue());
        } else {
            cellValue = cell.getStringCellValue();
        }
        return cellValue;
    }
    public static String getCellValue(int rowNum,int cellNum){

        String cellValue = null;
        Cell cell = sheet.getRow(rowNum).getCell(cellNum);
        if (cell.getCellType() == CellType.NUMERIC) {
            cellValue = cell.toString();
        } else {
            cellValue = cell.getStringCellValue();
        }
        return cellValue;

    }
    /**
     * Gets the cell data from the specified sheet and returns it as a 2D array.
     *
     * @param sheetName The name of the sheet.
     * @return A 2D array containing the cell data.
     */
    public static Object[][] getCellData(String excelFile,String sheetName) {
        try {
            loadWorkbook(excelFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        sheet = workbook.getSheet(sheetName);
        int rowNum = sheet.getLastRowNum();
        int cellNum = sheet.getRow(0).getLastCellNum();
        Object[][] data = new Object[rowNum][cellNum];
        for (int i = 0; i < rowNum; i++) {
            for (int j = 0; j < cellNum; j++) {
                String value = getCellValue((i + 1), j);
                data[i][j] = value;
            }
        }

        return data;
    }

    /**
     * Sets the value of the cell at the specified row and column in the specified sheet.
     *
     * @param sheetName The name of the sheet.
     * @param rowNum    The row number.
     * @param cellNum   The column number.
     * @param value     The value to set.
     */
    public static void setCellData(String sheetName, int rowNum, int cellNum, String value) {
        sheet = workbook.getSheet(sheetName);
        Row row = sheet.getRow(rowNum);
        if (value != null) {
            sheet.getRow(rowNum).createCell(cellNum).setCellValue(value);
            row.getCell(cellNum).setCellStyle(getStyle(value));
        }
    }


    /**
     * Writes the workbook to the specified Excel file.
     *
     * @param excelFile The file path of the Excel file to write.
     */
    public static void writeExcelFile(String excelFile) {
        try (FileOutputStream outputStream = new FileOutputStream(excelFile)) {
            workbook.write(outputStream);
        } catch (IOException e) {
            ExtentReportManager.logStacktrace(e);
        }
        try {
            workbook.close();
        } catch (IOException e) {
            ExtentReportManager.logStacktrace(e);
        }
    }




    /**
     * Gets the cell style based on the status string.
     *
     * @param status The status string (e.g., "pass", "fail", "blocked", "skip").
     * @return The cell style.
     */
    private static CellStyle getStyle(String status) {
        CellStyle style = workbook.createCellStyle();
        Font font = workbook.createFont();

        switch (status.toLowerCase()) {
            case "pass":
                font.setColor(IndexedColors.GREEN.getIndex());
                font.setBold(true);
                style.setFont(font);
                return style;

            case "fail":
                font.setColor(IndexedColors.RED.getIndex());
                font.setBold(true);
                style.setFont(font);
                return style;

            case "blocked":
                font.setColor(IndexedColors.BLUE.getIndex());
                font.setBold(true);
                style.setFont(font);
                return style;
            case "skip":
                font.setColor(IndexedColors.DARK_YELLOW.getIndex());
                font.setBold(true);
                style.setFont(font);
                return style;
            default:
                return style;
        }

    }
}
