package U2.L2.fm.model;
import U2.L2.fm.controller.DBHelper;
import U2.L2.fm.controller.GUI;
import U2.L2.fm.model.datasets.User;
import U2.L2.fm.model.util.PasswordHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Сергеева on 18.03.2016.
 *
 */
public class FinancialManager {

    private DBHelper dbHelper;
    private final Logger logger = LoggerFactory.getLogger(FinancialManager.class.getName());
    private GUI controller;

    public FinancialManager(DBHelper dbHelper, GUI controller) {
        this.dbHelper = dbHelper;
        this.controller = controller;
        dbHelper.createTable();
    }

    public void start(){
        controller.show();
        int i = Integer.valueOf(controller.getUserInput());
        switch (i){
            case 1: { //авторизоваться
                controller.sendMessage("Введите логин: ");
                String login = controller.getUserInput();
                controller.sendMessage("Введите пароль: ");
                String password = controller.getUserInput();
                if (signIn(login, password)) {
                    controller.sendMessage("Авторизация прошла успешно!");
                } else {
                    controller.sendMessage("Неверный логин/пароль");
                }
            }
            break;
            case 2: {
                controller.sendMessage("Введите логин: ");
                String login = controller.getUserInput();
                controller.sendMessage("Введите пароль: ");
                String password = controller.getUserInput();
                if (!signUp(login, password)) {
                    controller.sendMessage("Пользователь с таким логином уже существует.");
                } else
                controller.sendMessage("Вы успешно зарегистрировались!");
            }
            break;

        }
    }


    public boolean signIn(String login, String password){
        User user = dbHelper.getUser(login);

        if (user != null && new String(PasswordHelper.getInstance().getSha256Hash(password)).equals(user.getPassword())){
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

        dbHelper.addUser(new User(name, new String(PasswordHelper.getInstance().getSha256Hash(password))));
        logger.info("New User with login: {} and password: {} have added. ", name, password);
        return true;
    }
}
