package com.seleniumframework.core;

import org.apache.poi.ss.usermodel.*;

import java.io.File;

public class ExcelUtils {
     static Workbook workbook;

    public ExcelUtils(String excelFilePath) throws Throwable {
           workbook = WorkbookFactory.create(new File(excelFilePath));
    }

    public static int getRowCount(String sheetName){
        Sheet sheet = workbook.getSheet(sheetName);
        return sheet.getLastRowNum();
    }

    public static String getCellData(String sheetName,int rowNum,int cellNum){
        String cellValue = null;
        Sheet sheet = workbook.getSheet(sheetName);
        Cell cell = sheet.getRow(rowNum).getCell(cellNum);
        if (cell.getCellType() == CellType.NUMERIC){
            cellValue = String.valueOf(cell.getNumericCellValue());
        }else {
            cellValue = cell.getStringCellValue();
        }
        return  cellValue;
    }
    public static void setCellData(String ExcelFile,String sheetName,int rowNum,int cellNum,String value){
        Sheet sheet = workbook.getSheet(sheetName);
        Row row = sheet.getRow(rowNum);
        Cell cell = row.createCell(cellNum);
        if (value!=null){
            cell.setCellValue(value);
            row.getCell(cellNum).setCellStyle(getStyle(value));
        }else{
            cell.setCellValue(value);
        }

    }
     private static CellStyle getStyle(String status){
         CellStyle style = workbook.createCellStyle();
         Font font = workbook.createFont();

        switch (status.toLowerCase()){
            case "pass":
                font.setColor(IndexedColors.GREEN.getIndex());
                font.setBold(true);
                style.setFont(font);

            case "fail":
                font.setColor(IndexedColors.RED.getIndex());
                font.setBold(true);
                style.setFont(font);

            case "blocked":
                font.setColor(IndexedColors.BLUE.getIndex());
                font.setBold(true);
                style.setFont(font);
            case "skip":
                font.setColor(IndexedColors.DARK_YELLOW.getIndex());
                font.setBold(true);
                style.setFont(font);
        }

        return style;

    }
}
