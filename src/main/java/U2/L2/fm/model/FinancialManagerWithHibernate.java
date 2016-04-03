package U2.L2.fm.model;

import U2.L2.fm.model.datasets.Account;
import U2.L2.fm.model.datasets.Record;
import U2.L2.fm.model.datasets.User;
import U2.L2.fm.model.interfaces.Manageable;
import U2.L2.fm.model.util.PasswordHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
            //System.out.println("User with such login exists. Please choose other login or sign in with your login/password.");
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
        return null;
    }

    @Override
    public boolean addRecord(String descAccount, String nameCategory, boolean type, Date date, double amount, String recordDesc) {
        return false;
    }

    @Override
    public List<Record> getRecords(Account account) {
        return dbService.getRecords(account);
    }
}
