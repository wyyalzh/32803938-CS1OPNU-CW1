package datamanager.transform;

import datamanager.model.DataRecord;
import datamanager.model.DataSet;

public class FilterGreaterThanTransformer implements Transformer {

    @Override
    public DataSet transform(DataSet original, String field, String value) {
        double threshold;
        try {
            threshold = Double.parseDouble(value);
        } catch (NumberFormatException e) {
            return new DataSet(); // 如果值不是数字，就返回空结果
        }

        DataSet result = new DataSet();
        for (DataRecord record : original.getRecords()) {
            try {
                double recordValue = Double.parseDouble(record.getField(field));
                if (recordValue > threshold) {
                    result.addRecord(record);
                }
            } catch (NumberFormatException ignored) {}
        }

        return result;
    }
}

