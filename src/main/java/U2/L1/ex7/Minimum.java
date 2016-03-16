package U2.L1.ex7;

import java.util.Comparator;

/**
 * Created by Сергеева on 16.03.2016.
 * generics в интерфесах
 * если минимум, значит тип должен уметь сравнивать себя с другим объектом
 * для этого параметр типа должен имплементить интерфейс Comparable
 *    //Comparable - сам себя с кем нибудь
 *    Comparator - два объекта сравнивает
 */
public interface Minimum<T extends Comparable<T>> {
    T min();

}
