package datamanager.io;

import datamanager.model.DataRecord;
import datamanager.model.DataSet;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class CSVExporter {

    public static void exportToCSV(DataSet dataSet, String filepath) {
        if (dataSet.getRecords().isEmpty()) {
            System.out.println("⚠️ No data to export.");
            return;
        }

        try (FileWriter writer = new FileWriter(filepath)) {
            // 写入表头（第一行）
            DataRecord first = dataSet.getRecords().get(0);
            String header = String.join(",", first.getAllFields().keySet());
            writer.write(header + "\n");

            // 写入数据行
            for (DataRecord record : dataSet.getRecords()) {
                StringBuilder line = new StringBuilder();
                for (String key : first.getAllFields().keySet()) {
                    String value = record.getField(key);
                    line.append(value).append(",");
                }
                // 删除末尾逗号
                if (line.length() > 0) line.setLength(line.length() - 1);
                writer.write(line + "\n");
            }

            System.out.println("✅ Export completed: " + filepath);

        } catch (IOException e) {
            System.out.println("❌ Failed to export: " + e.getMessage());
        }
    }
}

