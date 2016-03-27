package U2.L2.fm.controller;

import U2.L2.fm.model.interfaces.GUI;
import U2.L2.fm.model.interfaces.Manageable;
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
public class LoginWindowController implements GUI {

    private final Logger logger = LoggerFactory.getLogger(LoginWindowController.class.getName());
    private Manageable fm;


    public LoginWindowController(Manageable fm) {
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

    @Override
    public boolean addAccount(String username, String accountDesc, double amount) {
        return fm.addAccount(username, accountDesc, amount);
    }

    @Override
    public Set<Account> getAccounts(String owner) {
        return fm.getAccounts(owner);
    }

    public String[] updateListAccount() {
        Set<Account> temp = getAccounts(getOwner());
        Account[] data = temp.toArray(new Account[temp.size()]);
        String[] strData = new String[temp.size()];
        for (int i = 0; i < strData.length; i++) {
            strData[i] = data[i].getDescription();
        }
        return strData;
    }


}
