package datamanager.transform;

import datamanager.model.DataSet;

public interface Transformer {
    DataSet transform(DataSet original, String field, String value);
}
