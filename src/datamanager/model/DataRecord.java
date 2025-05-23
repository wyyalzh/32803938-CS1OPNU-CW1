package datamanager.model;

import java.util.HashMap;
import java.util.Map;

public class DataRecord {
    private Map<String, String> fields;

    public DataRecord() {
        this.fields = new HashMap<>();
    }

    public void setField(String key, String value) {
        fields.put(key, value);
    }

    public String getField(String key) {
        return fields.getOrDefault(key, "");
    }

    public Map<String, String> getAllFields() {
        return fields;
    }

    @Override
    public String toString() {
        return fields.toString();
    }
}
