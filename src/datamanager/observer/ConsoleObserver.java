package datamanager.observer;

public class ConsoleObserver implements Observer {

    @Override
    public void onDataChanged() {
        System.out.println("🔔 Observer: Data has been updated!");
    }
}
