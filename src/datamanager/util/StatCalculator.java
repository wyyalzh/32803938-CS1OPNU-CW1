package datamanager.util;

import datamanager.model.DataRecord;
import datamanager.model.DataSet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StatCalculator {

    public static double calculateMean(DataSet dataSet, String field) {
        List<Double> values = extractFieldValues(dataSet, field);
        if (values.isEmpty()) return 0;

        double sum = 0;
        for (double v : values) {
            sum += v;
        }
        return sum / values.size();
    }

    public static double calculateMedian(DataSet dataSet, String field) {
        List<Double> values = extractFieldValues(dataSet, field);
        if (values.isEmpty()) return 0;

        Collections.sort(values);
        int n = values.size();
        if (n % 2 == 1) {
            return values.get(n / 2);
        } else {
            return (values.get(n / 2 - 1) + values.get(n / 2)) / 2.0;
        }
    }

    public static double calculateStdDev(DataSet dataSet, String field) {
        List<Double> values = extractFieldValues(dataSet, field);
        if (values.isEmpty()) return 0;

        double mean = calculateMean(dataSet, field);
        double sumSq = 0;
        for (double v : values) {
            sumSq += Math.pow(v - mean, 2);
        }
        return Math.sqrt(sumSq / values.size());
    }

    private static List<Double> extractFieldValues(DataSet dataSet, String field) {
        List<Double> values = new ArrayList<>();
        for (DataRecord r : dataSet.getRecords()) {
            try {
                values.add(Double.parseDouble(r.getField(field)));
            } catch (NumberFormatException ignored) {}
        }
        return values;
    }
}
