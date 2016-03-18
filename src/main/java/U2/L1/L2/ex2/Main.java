package U2.L1.L2.ex2;

import U2.L1.L2.ex2.datasets.User;

/**
 * Created by Ксения on 17.03.2016.
 *
 */
public class Main {

    public static void main(String[] args) {
        DBHelper dbHelper = DBHelper.getInstance();
        dbHelper.createTable();
        dbHelper.addUser(new User("Alisa", "123"));
        System.out.println(dbHelper.getUser("Alisa"));

    }
    
    // TODO: 18.03.2016 написать процедуру/авторизации регистрации пользователя, проверив имя на уникальность и пароль на совпадение
}
