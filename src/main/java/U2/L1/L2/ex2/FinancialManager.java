package U2.L1.L2.ex2;
import U2.L1.L2.ex2.datasets.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;
import java.util.Set;

/**
 * Created by Сергеева on 18.03.2016.
 *
 */
public class FinancialManager {

    private DBHelper dbHelper;
    private final Logger logger = LoggerFactory.getLogger(FinancialManager.class.getName());

    public void start(){
        dbHelper = DBHelper.getInstance();
//        System.out.println("Вас приветствует система регистрации нового пользователя. ");
//        System.out.println("Введите имя: ");
//        Scanner sc = new Scanner(System.in);
//        String login = sc.nextLine();
//        System.out.println("Введите пароль: ");
//        String pswd = sc.nextLine();



//        dbHelper.createTable();
//        dbHelper.addUser(new User("Alisa", "123"));
//        System.out.println(dbHelper.getUser(login));
//
//        System.out.println(signIn(login, pswd));
        Set<String> userNames = dbHelper.getUserNames();
        for (String userName : userNames) {
            System.out.println(userName);
        }

//        System.out.println(signUp(login, pswd) ?
//                "Вы зарегистрировались успешно. Введите логин/пароль" :
//                "Возможно данный логин уже используется");
    }

    // TODO: 18.03.2016 написать процедуру авторизации/регистрации пользователя, проверив имя на уникальность и пароль на совпадение
    //получаем set из юзеров -> если в нем больше чем 1 пользователь - значит имя не уникально, пусть еще раз регистрируется
    // TODO: 18.03.2016 сделать RegistrationController для связи FM и Main

    public boolean signIn(String login, String password){
        User user = dbHelper.getUser(login);

        if (user != null && password.equals(user.getPassword())){
            logger.info("User {} is entered.", login);
            return true;
        }
        return false;

    }

    public boolean signUp(String name, String password) {
        User user = dbHelper.getUser(name);
        if (user != null){
            logger.info("User with such login exists. {} rejected to Login form", name);
            System.out.println("User with such login exists. Please choose other login or sign in with your login/password.");
            return false;
        }
        dbHelper.addUser(new User(name, password));
        logger.info("New User with login: {} and password: {} have added. ", name, password);
        return true;
    }

}
