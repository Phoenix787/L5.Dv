package U2.L3.ex1;

/**
 * Created by Ксения on 19.03.2016.
 * swing lesson
 */
public class Main {
    public static void main(String[] args) {
        Timer timer = new Timer(3);

        //добавляем наблюдателей и через три секунды после запуска таймера они все отработают,
        // потому что таймер всем, кто на него подписался, отослал сообщение

        timer.addObserver(new Task("Mail 1"));
        timer.addObserver(new Task("Mail 2"));
        timer.addObserver(() -> System.out.println("Event handled by анонимным внутренним наблюдателем!!!"));

        timer.start();
    }


}
