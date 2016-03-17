package U2.L1.L1.ex7;

/**
 * Created by Сергеева on 16.03.2016.
 * Коллекция, которая примет элементы которые можно сравнивать
 * мы не можем накладывать фильтры где хотим, единственное место где можно
 * его наложить - при описании класса. Если там не сделали, то дальше мы уже не можем
 * наложить фильтр
 */
//public class MainCollection<T extends Comparable<T> & Minimum<T>> // такой вариант тоже допустим
public class MainCollection<T extends Comparable<T>> implements Minimum<T> {
    T[] objects;

    public MainCollection(T[] objects) {
        this.objects = objects;
    }


    @Override
    public T min() {
        if (objects == null || objects.length < 1) {
            return null;
        }

        T min = objects[0];
        for (int i = 1; i < objects.length; i++) {
            if (objects[i].compareTo(min) < 0){
                min = objects[i];
            }
        }
        return min;
    }
}
