package U2.L2.fm.model;

import U2.L2.fm.controller.DBHelper;
import U2.L2.fm.model.datasets.*;
import U2.L2.fm.model.enums.Type;
import U2.L2.fm.model.interfaces.Manageable;
import U2.L2.fm.model.util.PasswordHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Сергеева on 18.03.2016.
 *
 */
public class FinancialManager implements Manageable {

    private DBHelper dbHelper;
    private String owner;
    private final Logger logger = LoggerFactory.getLogger(FinancialManager.class.getName());

    public FinancialManager(DBHelper dbHelper) {
        this.dbHelper = dbHelper;
        dbHelper.createTable();
    }

    public boolean signIn(String login, String password){
        User user = dbHelper.getUser(login);

        if (user != null && new String(PasswordHelper.getInstance().getSha256Hash(password)).equals(user.getPassword())){
            logger.info("User {} is entered.", login);
            owner = login;
            return true;
        }
        return false;

    }

    public boolean signUp(String name, String password) {
        User user = dbHelper.getUser(name);
        if (user != null){
            logger.info("User with such login exists. {} rejected to Login form", name);
            //System.out.println("User with such login exists. Please choose other login or sign in with your login/password.");
            return false;
        }

        dbHelper.addUser(new User(name, new String(PasswordHelper.getInstance().getSha256Hash(password))));
        owner = name;
        logger.info("New User with login: {} and password: {} have added. ", name, password);
        return true;
    }

    public Set<String> getUserNames() {
        return dbHelper.getUserNames();
    }

    public String getOwner(){
        return owner;
    }

    /*-----------------ACCOUNT----------------------------------------------------*/

    public boolean addAccount(String username, String accountDesc, double amount){
        User user = dbHelper.getUser(username);
        if (user != null) {
            logger.info("Added new account to user: {}", username);
            dbHelper.addAccount(user, new Account(accountDesc, amount));
            return true;
        }
        return false;
    }


    public Set<Account> getAccounts(String owner){
        User user = dbHelper.getUser(owner);
        if (user != null) {
            return dbHelper.getAccounts(user);
        }
        return new HashSet<>();
    }

    @Override
    public Account getAccount(String desc) {
        return null;
    }

    /*-----------------RECORDS----------------------------------------------------*/

    public boolean addRecord(String descAccount, String nameCategory, boolean type, Date date, double amount, String recordDesc){

        Account account = dbHelper.getAccount(descAccount);
        Category category = dbHelper.getCategory(nameCategory);
        if (account != null && category != null){
            logger.info("New record to account {} is added", descAccount);
            Type t = type ? Type.EXPAND : Type.INCOME;
            dbHelper.addRecord(account, new Record(date, category, type, amount, recordDesc));
            return true;
        }
        return false;
    }

    @Override
    public List<Record> getRecords(Account account) {
        return null;
    }


}
