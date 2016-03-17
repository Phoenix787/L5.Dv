package U2.L1.L1.ex7;

/**
 * Created by Сергеева on 16.03.2016.
 */
public class Main {
    public static void main(String[] args) {
        String[] strings = {"Kitty", "Tom", "Jerry", "Alpha"}; //сравнивает по алфавиту если стринги
        MainCollection<String> mainCollection = new MainCollection<>(strings);
        System.out.println(mainCollection.min());


        Integer[] integers = {5, 6, 7, 4, 2, 9};
        MainCollection<Integer> mainCollection2 = new MainCollection<>(integers);
        System.out.println(mainCollection2.min());
    }
}
