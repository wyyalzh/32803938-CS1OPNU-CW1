package datamanager.io;

import datamanager.model.DataRecord;
import datamanager.model.DataSet;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CSVImporter {

    public static DataSet importFromCSV(String filepath) {
        DataSet dataSet = new DataSet();

        try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
            String headerLine = br.readLine();
            if (headerLine == null) return dataSet;

            String[] headers = headerLine.split(",");

            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                DataRecord record = new DataRecord();
                for (int i = 0; i < headers.length && i < values.length; i++) {
                    record.setField(headers[i].trim(), values[i].trim());
                }
                dataSet.addRecord(record);
            }

        } catch (IOException e) {
            System.out.println("Error reading CSV file: " + e.getMessage());
        }

        return dataSet;
    }
}
