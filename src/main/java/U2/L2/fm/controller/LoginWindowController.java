package U2.L2.fm.controller;

import U2.L2.fm.model.FinancialManager;
import U2.L2.fm.model.datasets.Account;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Set;

/**
 * Created by Ксения on 19.03.2016.
 * методы по обновлению данных от GUI к модели
 * и от модели к GUI
 *
 * добавить как-то получение данных из базы данных для доступа к приложению
 */
public class LoginWindowController implements GUI{

    private final Logger logger = LoggerFactory.getLogger(LoginWindowController.class.getName());
    private FinancialManager fm;


    public LoginWindowController(FinancialManager fm) {
        this.fm = fm;
    }

    public boolean authenticate(String name, String password) {
        /* выборка из базы данных */
        return fm.signIn(name, password);
    }

    @Override
    public boolean register(String username, String password) {

        return fm.signUp(username, password);
    }

    public Set<String> getNames() {
        return fm.getUserNames();
    }

    public Set<Account> getAccounts(){
        return null;
    }

    @Override
    public String getOwner(){
        return fm.getOwner();
    }

}
