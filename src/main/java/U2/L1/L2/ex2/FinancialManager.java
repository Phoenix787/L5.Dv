package U2.L1.L2.ex2;
import U2.L1.L2.ex2.datasets.User;

import java.util.Scanner;

/**
 * Created by Сергеева on 18.03.2016.
 */
public class FinancialManager {

    private DBHelper dbHelper;

    public void start(){
        dbHelper = DBHelper.getInstance();
        System.out.println("Введите имя: ");
        Scanner sc = new Scanner(System.in);
        String login = sc.nextLine();
        System.out.println("Введите пароль: ");
        String pswd = sc.nextLine();



//        dbHelper.createTable();
//        dbHelper.addUser(new User("Alisa", "123"));
        System.out.println(dbHelper.getUser(login));
    }

    // TODO: 18.03.2016 написать процедуру авторизации/регистрации пользователя, проверив имя на уникальность и пароль на совпадение
    //получаем set из юзеров -> если в нем больше чем 1 пользователь - значит имя не уникально, пусть еще раз регистрируется
    // TODO: 18.03.2016 сделать RegistrationController для связи FM и Main

    public boolean signIn(String login, String password){
        return false;
    }

    public boolean signUp(String name, String password) {
        return false;
    }

}
