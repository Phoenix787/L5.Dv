package U2.L3.ex1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Ксения on 19.03.2016.
 */
public class Timer implements Observable {
    private int delay; // время через какое этот таймер срабатывает
    //список всех наблюдателей
    private List<Observer> observers = new ArrayList<>();

    public Timer(int delay) {
        this.delay = delay;
    }

    public void start(){
        try {
            TimeUnit.SECONDS.sleep(delay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            notifyObservers();
        }
    }
    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.handleEvent();
        }
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);

    }

    @Override
    public void deleteObserver(Observer observer) {
        observers.remove(observer);
    }
}
