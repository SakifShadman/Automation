package SeleniumSessions;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;

public class ReadCSVData {
    public static void main(String[] args) throws IOException, CsvValidationException {
        //installing the CSV reader class

        CSVReader reader = new CSVReader(new FileReader("src/test/java/com/testdata/ImportData.csv"));


        //reading the data of the CSV file
        StringBuffer buffer = new StringBuffer();
        String data[];

        while ((data = reader.readNext()) != null) {

            for (int i=0; i<data.length; i++) {
                System.out.println(data[i] + " ");
            }
            System.out.println(" ");
        }
    }
}