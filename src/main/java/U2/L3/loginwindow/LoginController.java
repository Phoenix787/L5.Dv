package U2.L3.loginwindow;

/**
 * Created by Сергеева on 23.03.2016.
 * +++
 */
public class LoginController {
    //подключить модель финансового менеджера
    //сюда можно попробовать подключить контроллер


    public static boolean authenticate(String name, String password) {
        /* выборка из базы данных */
        return name.equals("admin") && password.equals("admin");
    }
}
