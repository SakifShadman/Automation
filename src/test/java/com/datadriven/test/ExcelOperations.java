package com.datadriven.test;

import com.excel.utility.Xls_Reader;

public class ExcelOperations {
    public static void main(String[] args) {

        Xls_Reader reader = new Xls_Reader("src/test/java/com/testdata/ParaBankTestData.xlsx");

        if(!reader.isSheetExist("HomePage")) {
            reader.addSheet("HomePage");
        }

        int colCount = reader.getColumnCount("RegTestData");
        System.out.println("Total columns present in RegTestData sheet: " + colCount);

        System.out.println(reader.getCellRowNum("RegTestData", "firstname", "Sakif"));
    }
}