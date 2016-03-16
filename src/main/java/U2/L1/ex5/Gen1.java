package U2.L1.ex5;

import U2.L1.ex4.Animal;

/**
 * Created by Сергеева on 16.03.2016.
 * <T extends Number> - эти ограничения применяются в момент создания класса
 * т. е. при создании объекта компилятор может проверить что мы эти ограничения выполняем
 *
 */
public class Gen1<T extends Number> {
    T number;

    public Gen1(T number) {
        this.number = number;
    }

    /**
     *
     * @param operand
     * хитрая вещь - стирание типов, во время выполнения T стирается
     * когда мы говорим <T extends Number> -> T придет в этот метод уже со всеми ограничениями
     * соответственно создастся объект класса параметризованный определенным типом.
     * Gen1<Integer> i1 -> метод будет требовать в аргументы Gen1<Integer>
     * Gen1<Float> f1 -> здесь метод будет требовать в аргументы Gen1<Float>
     */
//    void showDelta(Gen1<T> operand) {
//        System.out.println(number.doubleValue() - operand.number.doubleValue());
//    }

    //-----------------------------------------------------------------------------------

    //варианты исправления
    //1 вариант
//    void showDelta(Gen1 operand) {
//        System.out.println(number.doubleValue() - operand.number.doubleValue());
//    }
//----------------------------------------------------------------------------------------
    //2 вариант
    //можно вместо T поставить <?>, тогда получится что операнд неизвестно по какому типу
    //wildcards
//    void showDelta(Gen1<?> operand) {
//        System.out.println(number.doubleValue() - operand.number.doubleValue());
//    }
    //------------------------------------------------------------------------------------

    // что делать если нам нужно чтобы операнд был типом не просто какой-либо,
    // а определенного класса
    // чтобы в параметр передавался кто-нибудь, кто является потомком от Number
    // то есть дополнительное ограничение в рамках верхнего ограничения

    void showDelta(Gen1<? extends Number> operand) {
        System.out.println(number.doubleValue() - operand.number.doubleValue());
    }

    //************************************************************************************






}
