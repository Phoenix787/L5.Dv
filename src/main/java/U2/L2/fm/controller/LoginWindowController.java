package U2.L2.fm.controller;

import U2.L2.fm.model.datasets.Account;
import U2.L2.fm.model.datasets.Category;
import U2.L2.fm.model.datasets.Record;
import U2.L2.fm.model.interfaces.GUI;
import U2.L2.fm.model.interfaces.Manageable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
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

    /**
     * Метод для регистрации нового пользователя
     * @param username - имя нового пользователя
     * @param password - пароль нового пользователя
     * @return true - если новый пользователь добавлен
     *         false - если такой пользователь существует
     */

    @Override
    public boolean register(String username, String password) {

        return fm.signUp(username, password);
    }

    /**
     * Метод, который возращает набор имен пользователей в системе
     * @return Set<String>
     */

    public Set<String> getNames() {
        return fm.getUserNames();
    }

    /**
     * Метод, возвращающий набор счетов конкретного пользователя
     * @return Set<Account>
     */

    @Override
    public String getOwner(){
        return fm.getOwner();
    }

    /**
     * Метод добавления нового счета конкретному пользователю
     * @param username - имя пользователя, которому добавляется новый счет
     * @param accountDesc - описание счета (наименование)
     * @param amount - сумма счета
     * @return возвращает <b>true</b> в случае успеха и <b>false</b> в обратном случае.
     */
    @Override
    public boolean addAccount(String username, String accountDesc, double amount) {
        return fm.addAccount(username, accountDesc, amount);
    }

    /**
     * Метод, позволяющий получить список счетов для конкретного пользователя
     * @param owner - владелец счетов
     * @return Set<Accounts></Accounts>
     */

    @Override
    public Set<Account> getAccounts(String owner) {

        return fm.getAccounts(owner);
    }

    @Override
    public Set<Record> getRecords(Account account) {
        return fm.getRecords(account);
    }

    @Override
    public Account getAccount(String desc) {
        return fm.getAccount(desc);
    }

    /**
     * Вспомогательный метод для списка, который получает набор типа Account и возвращает массив типа String,
     * чтобы обновить модель списка.
     * @return String[]
     */

    public String[] updateListAccount() {
        Set<Account> temp = getAccounts(getOwner());
        Account[] data = temp.toArray(new Account[temp.size()]);
        String[] strData = new String[temp.size()];
        for (int i = 0; i < strData.length; i++) {
            strData[i] = data[i].getDescription();
        }
        return strData;
    }

    @Override
    public Set<Category> getCategories() {
        return fm.getCategories();
    }

    @Override
    public boolean addCategory(String text) {
        return fm.addCategory(text);
    }

    @Override
    public boolean addRecord(Account account, String nameCategory, Date date, Double amount, Boolean checked, String recDesc) {
        return fm.addRecord(account, nameCategory, checked, date, amount, recDesc);
    }


}
