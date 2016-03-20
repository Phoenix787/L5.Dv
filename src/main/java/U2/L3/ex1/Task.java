package U2.L3.ex1;

/**
 * Created by Ксения on 19.03.2016.
 */
public class Task implements Observer {
    private String name;

    public Task(String name) {
        this.name = name;
    }

    @Override
    public void handleEvent() {
        System.out.println("Event handled by task: " + name);
    }
}
