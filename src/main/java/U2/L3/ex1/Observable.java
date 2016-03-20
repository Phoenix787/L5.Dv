package U2.L3.ex1;

/**
 * Created by Ксения on 19.03.2016.
 * что-то наблюдаемое
 */
public interface Observable {
    void notifyObservers(); // уведомить всех наблюдателей, что какое-то событие у него произошло

    void addObserver(Observer observer);

    void deleteObserver(Observer observer);
}
