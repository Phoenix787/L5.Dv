package ex2.Model;

/**
 *
 * Created by Сергеева on 10.03.2016.
 */
public class Field {
    public enum Type{X, O, NOT_SET} // класс, который автоматически создает экземпляры самого себя
    private static final int SIZE = 3;

    Type cells[][];

    public Field() {
        cells = new Type[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                cells[i][j] = Type.NOT_SET;
            }
        }
    }

    public void show(){
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                switch (cells[i][j]){
                    case X:
                        System.out.print("X");
                        break;
                    case O:
                        System.out.print("O");
                        break;
                    case NOT_SET:
                        System.out.print(".");
                        break;
                }

            }
            System.out.println();
        }
        System.out.println();
    }

//    public void doShoot(Point point, Type type) {
//        // TODO: 10.03.2016 проверка - можно ли в эту ячейку стрелять или она уже занята
//        if(cells[point.getX()][point.getY()] == Type.NOT_SET) {
//            cells[point.getX()][point.getY()] = type;
//        }
//    }

    public boolean doShoot(Point point, Type type) {
        // TODO: 10.03.2016 проверка - можно ли в эту ячейку стрелять или она уже занята
        if(cells[point.getX()][point.getY()] == Type.NOT_SET) {
            cells[point.getX()][point.getY()] = type;
            return true;
        }
        return false;
    }

    public boolean checkIsWin(Type type){
        boolean isWin = false;
        if (cells[0][0] == type && cells[0][1] == type && cells[0][2] == type)
            isWin = true;
        if (cells[0][0] == type && cells[1][1] == type && cells[2][2] == type)
            isWin = true;
        if (cells[2][0] == type && cells[2][1] == type && cells[2][2] == type)
            isWin = true;
        if (cells[2][0] == type && cells[1][1] == type && cells[0][2] == type)
            isWin = true;
        if (cells[0][0] == type && cells[1][0] == type && cells[2][0] == type)
            isWin = true;
        if (cells[0][1] == type && cells[1][1] == type && cells[2][1] == type)
            isWin = true;
        if (cells[0][2] == type && cells[1][2] == type && cells[2][2] == type)
            isWin = true;

        return isWin;
    }
}
