package U2.L2.fm.model;

import U2.L2.fm.model.datasets.Account;
import U2.L2.fm.model.interfaces.Manageable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.Set;

/**
 * Created by Ксения on 26.03.2016.
 */
public class FinancialManagerWithHibernate implements Manageable {
    private DBService dbService;
    private String owner;
    private Logger logger = LoggerFactory.getLogger(FinancialManagerWithHibernate.class.getName());

    public FinancialManagerWithHibernate(DBService dbService) {
        this.dbService = dbService;
    }


    @Override
    public boolean signIn(String login, String password) {
        return false;
    }

    @Override
    public boolean signUp(String name, String password) {
        return false;
    }

    @Override
    public Set<String> getUserNames() {
        return null;
    }

    @Override
    public String getOwner() {
        return owner;
    }

    @Override
    public boolean addAccount(String username, String accountDesc, double amount) {
        return false;
    }

    @Override
    public Set<Account> getAccounts(String owner) {
        return null;
    }

    @Override
    public boolean addRecord(String descAccount, String nameCategory, boolean type, Date date, double amount, String recordDesc) {
        return false;
    }
}
