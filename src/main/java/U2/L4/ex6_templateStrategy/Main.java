package U2.L4.ex6_templateStrategy;

/**
 * Created by Ксения on 27.03.2016.
 * Шаблон Стратегия:
 * * подмена алгоритма
 * * аналог callback
 *
 * Стратегия - это означает что, мы придумываем интерфейс: как и что делать, и после этого сохраняем например стратегию
 * нашего движения
 * организовать разные способы работы предмету и при этом все части функционально независимы
 */
public class Main {

    public static void main(String[] args) {
        Mover mover = new Mover(new Circle());

        //саму стратегию движения можем прям тут и задать
        mover.move(new MoveStrategy() {
            @Override
            public void move(Drawable drawable) {
                drawable.draw();
                System.out.println("плавно");
            }
        });
// двигаем тот же самый объект, но используя другую стратегию движения
        mover.move(new MoveStrategy() {
            @Override
            public void move(Drawable drawable) {
                drawable.draw();
                System.out.println("скачкообразно!");
            }
        });
    }
}
