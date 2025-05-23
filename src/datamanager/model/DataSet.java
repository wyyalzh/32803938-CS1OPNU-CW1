package datamanager.model;

import java.util.ArrayList;
import java.util.List;

public class DataSet {
    private List<DataRecord> records;

    public DataSet() {
        this.records = new ArrayList<>();
    }

    public void addRecord(DataRecord record) {
        records.add(record);
    }

    public List<DataRecord> getRecords() {
        return records;
    }

    public int size() {
        return records.size();
    }

    @Override
    public String toString() {
        return "DataSet{" +
                "records=" + records +
                '}';
    }
}
