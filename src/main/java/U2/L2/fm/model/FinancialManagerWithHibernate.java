package U2.L2.fm.model;

import U2.L2.fm.model.datasets.Account;
import U2.L2.fm.model.datasets.Category;
import U2.L2.fm.model.datasets.Record;
import U2.L2.fm.model.datasets.User;
import U2.L2.fm.model.interfaces.Manageable;
import U2.L2.fm.model.util.PasswordHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class FinancialManagerWithHibernate implements Manageable {
    private DBService dbService;
    private String owner;
    private Logger logger = LoggerFactory.getLogger(FinancialManagerWithHibernate.class.getName());

    public FinancialManagerWithHibernate(DBService dbService) {
        this.dbService = dbService;
    }


    @Override
    public boolean signIn(String login, String password) {
        User user = dbService.getUser(login);

        if (user != null && new String(PasswordHelper.getInstance().getSha256Hash(password)).equals(user.getPassword())){
            logger.info("User {} is entered.", login);
            owner = login;
            return true;
        }
        return false;
    }

    @Override
    public boolean signUp(String name, String password) {
        User user = dbService.getUser(name);
        if (user != null){
            logger.info("User with such login exists. {} rejected to Login form", name);
            return false;
        }

        user = new User(name, new String(PasswordHelper.getInstance().getSha256Hash(password)));

        dbService.addUser(user);
        owner = name;
        logger.info("New User with login: {} and password: {} have added. ", name, password);
        return true;
    }

    @Override
    public Set<String> getUserNames() {
        return dbService.getUserNames();
    }

    @Override
    public String getOwner() {
        return owner;
    }

    /*------------------ACCOUNT---------------------------------------------------------*/

    @Override
    public boolean addAccount(String username, String accountDesc, double amount) {
        User user = dbService.getUser(username);
        if (user != null) {
            logger.info("Added new account to user: {}", username);
            dbService.addAccount(user, new Account(accountDesc, amount));
            return true;
        }
        return false;
    }

    @Override
    public Set<Account> getAccounts(String owner) {
        User user = dbService.getUser(owner);
        return dbService.getAccounts(user);
    }

    @Override
    public Account getAccount(String desc) {
        return dbService.getAccount(desc);
    }

    /*-------------------------RECORD------------------------------------------------------------*/

    @Override
    public boolean addRecord(Account account, String nameCategory, boolean type, Date date, double amount, String recordDesc) {
        //Account account = dbService.getAccount(descAccount);
        if (account != null) {
            Category category = dbService.getCategory(nameCategory);
            dbService.addRecord(account, new Record(date, category, type, amount, recordDesc));
            logger.info("Added new record to account: {}", account.getDescription());
            return true;
        }
        return false;
    }

    @Override
    public Set<Record> getRecords(Account account) {
        return dbService.getRecords(account);
    }


/*--------------------------------------------------- CATEGORY ----------------------------------------------------*/
    @Override
    public Set<Category> getCategories() {
        List<Category> list = dbService.getCategories();
        return new HashSet<>(list);
    }

    @Override
    public boolean addCategory(String text) {

        if (text != null && !"".equals(text)) {
            logger.info("Added new category - {}", text);
            dbService.addCategory(new Category(text));
            return true;
        }
        return false;
    }
}
