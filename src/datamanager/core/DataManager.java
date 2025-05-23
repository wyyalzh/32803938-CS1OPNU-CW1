package datamanager.core;

import datamanager.observer.Observer;
import java.util.ArrayList;
import java.util.List;


public class DataManager {
    private static DataManager instance;

    private Object currentDataSet; // 暂时占位，后面换成真实的 DataSet 类型

    // 私有构造器，防止外部实例化
    private DataManager() {
        System.out.println("DataManager initialized.");
    }

    // 公共静态方法获取唯一实例
    public static DataManager getInstance() {
        if (instance == null) {
            instance = new DataManager();
        }
        return instance;
    }

    public void setCurrentDataSet(Object dataSet) {
        this.currentDataSet = dataSet;
        notifyObservers();  // 数据更新时通知所有观察者
    }

    public Object getCurrentDataSet() {
        return currentDataSet;
    }
    private List<Observer> observers = new ArrayList<>();
    public void addObserver(Observer observer) {
        observers.add(observer);
    }
    private void notifyObservers() {
        for (Observer o : observers) {
            o.onDataChanged();
        }
    }
}
