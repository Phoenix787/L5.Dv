package U2.L2.fm.controller;

import U2.L2.fm.model.FinancialManager;
import U2.L2.fm.model.datasets.Account;
import U2.L2.fm.model.datasets.Category;
import U2.L2.fm.model.datasets.Record;
import U2.L2.fm.model.interfaces.GUI;
import U2.L2.fm.model.interfaces.Manageable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Set;

/**
 * Created by Ксения on 18.03.2016.
 *
 */
public class ConsoleController implements GUI {
    private final Logger logger = LoggerFactory.getLogger(FinancialManager.class.getName());
    private Manageable fm;



    public ConsoleController(Manageable fm) {
        this.fm = fm;

    }


    @Override
    public boolean authenticate(String username, String password) {

        return fm.signIn(username, password);
    }

    @Override
    public boolean register(String username, String password) {
        return fm.signUp(username, password);
    }

    @Override
    public Set<String> getNames() {
        return null;
    }

    @Override
    public String getOwner() {
        return null;
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
    public Set<Record> getRecords(Account account) {
        return null;
    }

    @Override
    public Account getAccount(String desc) {
        return null;
    }

    @Override
    public String[] updateListAccount() {
        return new String[0];
    }

    @Override
    public Set<Category> getCategories() {
        return null;
    }


}
