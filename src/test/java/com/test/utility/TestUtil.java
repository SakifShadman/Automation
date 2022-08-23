package com.test.utility;

import com.excel.utility.Xls_Reader;

import java.util.ArrayList;

public class TestUtil {
    static Xls_Reader reader;

    public static ArrayList<Object[]> getDataFromExcel(){

        ArrayList<Object[]> myData = new ArrayList<Object[]>();

        try {
            reader = new Xls_Reader("src/test/java/com/testdata/ParaBankTestData.xlsx");
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (int rowNum=2; rowNum<=reader.getRowCount("RegTestData"); rowNum++) {

            String firstName = reader.getCellData("RegTestData", "firstname", rowNum);
            String lastName = reader.getCellData("RegTestData", "lastname", rowNum);
            String address = reader.getCellData("RegTestData", "address", rowNum);
            String city = reader.getCellData("RegTestData", "city", rowNum);
            String state = reader.getCellData("RegTestData", "state", rowNum);
            String zipCode = reader.getCellData("RegTestData", "zipcode", rowNum);
            String phone = reader.getCellData("RegTestData", "phone", rowNum);
            String ssn = reader.getCellData("RegTestData", "ssn", rowNum);
            String userName = reader.getCellData("RegTestData", "username", rowNum);
            String passWord = reader.getCellData("RegTestData", "password", rowNum);

            Object ob[] = {firstName, lastName, address, city, state, zipCode, phone, ssn, userName, passWord};
            myData.add(ob);
        }
        return myData;
    }
}