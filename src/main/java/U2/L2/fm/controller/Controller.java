package U2.L2.fm.controller;

import U2.L2.fm.model.FinancialManager;
import U2.L2.fm.model.datasets.Account;
import U2.L2.fm.model.datasets.Category;
import U2.L2.fm.model.datasets.Record;
import U2.L2.fm.model.interfaces.GUI;
import U2.L2.fm.view.LoginWindow;

import java.util.Date;
import java.util.Set;

/**
 * Created by Ксения on 23.03.2016.
 */
public class Controller implements GUI {
    //подключить модель финансового менеджера
    //сюда можно попробовать подключить контроллер
    private FinancialManager fm;
    private LoginWindow frame;

    public Controller(FinancialManager fm, LoginWindow frame) {
        this.fm = fm;
        this.frame = frame;
    }



    public boolean authenticate(String name, String password) {
        /* выборка из базы данных */
        return fm.signIn(name, password);
    }

    @Override
    public boolean register(String username, String password) {
        return false;
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

    @Override
    public boolean addCategory(String text) {
        return false;
    }

    @Override
    public boolean addRecord(Account account, String nameCategory, Date date, Double amount, Boolean checked, String recDesc) {
        return false;
    }
}
