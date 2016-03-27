package U2.L4.ex6_templateStrategy;

/**
 * Created by Ксения on 27.03.2016.
 * этот класс может что-то разными способами двигать, для этого создаем интерфейс MoveStrategy
 * главное что сам Mover не будет завязан на саму стратегию. он получит стратегию движения через параметр в метод
 */
public class Mover {
    Drawable drawable;

    public Mover(Drawable drawable) {
        this.drawable = drawable;
    }

    public void move(MoveStrategy moveStrategy) {
        moveStrategy.move(drawable);
    }
}
