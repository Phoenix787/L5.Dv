package ex2.Model;

/**
 * Created by Сергеева on 10.03.2016.
 *
 */
public class Computer implements Shootable{
    public Point point;
    public Field.Type type = Field.Type.O;


    @Override
    public Point getShoot() {
        point = Point.getRandomPoint();
        return point;
    }


    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public Field.Type getType() {
        return type;
    }

    public void setType(Field.Type type) {
        this.type = type;
    }
}
