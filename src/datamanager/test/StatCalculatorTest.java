package datamanager.test;

import datamanager.model.DataRecord;
import datamanager.model.DataSet;
import datamanager.util.StatCalculator;
import org.junit.Assert;
import org.junit.Test;

public class StatCalculatorTest {

    private DataSet mockDataSet() {
        DataSet ds = new DataSet();

        ds.addRecord(record("age", "10"));
        ds.addRecord(record("age", "20"));
        ds.addRecord(record("age", "30"));

        return ds;
    }

    private DataRecord record(String field, String value) {
        DataRecord r = new DataRecord();
        r.setField(field, value);
        return r;
    }

    @Test
    public void testMean() {
        double mean = StatCalculator.calculateMean(mockDataSet(), "age");
        Assert.assertEquals(20.0, mean, 0.01);
    }

    @Test
    public void testMedian() {
        double median = StatCalculator.calculateMedian(mockDataSet(), "age");
        Assert.assertEquals(20.0, median, 0.01);
    }
}
