package U2.L2.fm.controller;

import U2.L2.fm.model.FinancialManager;
import U2.L2.fm.model.datasets.Account;
import U2.L2.fm.model.interfaces.GUI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Set;

/**
 * Created by Ксения on 18.03.2016.
 *
 */
public class ConsoleController implements GUI {
    private final Logger logger = LoggerFactory.getLogger(FinancialManager.class.getName());
    private FinancialManager fm;



    public ConsoleController(FinancialManager fm) {
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
    public String[] updateListAccount() {
        return new String[0];
    }


}
