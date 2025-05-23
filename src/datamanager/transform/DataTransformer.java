package datamanager.transform;

import datamanager.model.DataRecord;
import datamanager.model.DataSet;

import java.util.List;
import java.util.stream.Collectors;

public class DataTransformer {

    public static DataSet filterByFieldGreaterThan(DataSet original, String field, double threshold) {
        DataSet filtered = new DataSet();

        List<DataRecord> results = original.getRecords().stream()
            .filter(record -> {
                String value = record.getField(field);
                try {
                    return Double.parseDouble(value) > threshold;
                } catch (NumberFormatException e) {
                    return false;
                }
            })
            .collect(Collectors.toList());

        for (DataRecord r : results) {
            filtered.addRecord(r);
        }

        return filtered;
    }
}
