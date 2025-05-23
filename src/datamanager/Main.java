package datamanager;

import datamanager.core.DataManager;
import datamanager.io.CSVImporter;
import datamanager.model.DataSet;
import datamanager.transform.DataTransformer;
import datamanager.transform.Transformer;
import datamanager.transform.TransformerFactory;
import datamanager.observer.ConsoleObserver;
import datamanager.util.StatCalculator;
import datamanager.io.CSVExporter;


public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to the Data Science Data Manager!");

        // 测试 Singleton 初始化
        DataManager manager = DataManager.getInstance();
        manager.addObserver(new ConsoleObserver()); 
        DataSet imported = CSVImporter.importFromCSV("sample.csv");
        System.out.println("Imported records: " + imported.size());
        System.out.println(imported);
        DataSet filtered = DataTransformer.filterByFieldGreaterThan(imported, "age", 26);
        System.out.println("Filtered records (age > 26): " + filtered.size());
        System.out.println(filtered);
        Transformer transformer = TransformerFactory.createTransformer("greater");
        DataSet filtered2 = transformer.transform(imported, "age", "26");

        System.out.println("Factory filtered (age > 26): " + filtered2.size());
        System.out.println(filtered2);
        manager.setCurrentDataSet(imported);
        System.out.println("📊 Statistics on field 'age':");
        System.out.println("Mean: " + StatCalculator.calculateMean(imported, "age"));
        System.out.println("Median: " + StatCalculator.calculateMedian(imported, "age"));
        System.out.println("Std Dev: " + StatCalculator.calculateStdDev(imported, "age"));
        CSVExporter.exportToCSV(filtered2, "exported.csv");
    }
}
