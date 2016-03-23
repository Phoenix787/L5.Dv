package U2.L2.fm.model;
import U2.L2.fm.controller.DBHelper;
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

    public FinancialManager(DBHelper dbHelper) {
        this.dbHelper = dbHelper;
        dbHelper.createTable();
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
