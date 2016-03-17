package U2.L1.L2.ex2;

/**
 * Created by Ксения on 17.03.2016.
 */
public class Main {

    public int unt1;
    private String name;
    private static final int unt;
    static {
        unt = 10;
    }
    {
        unt1 = 2234;
        name = "Anonymous";
    }

    public int getUnt() {
        return unt1;
    }

    public String getName() {
        return name;
    }



    public Main(int unt1, String name) {
        this.unt1 = unt1;
        this.name = name;
    }

    public Main() {
    }

    public static void main(String[] args) {
        System.out.println(Main.unt);
        System.out.println(new Main().getName());
        System.out.println(new Main(24, "Alisa").getName());
    }
}
