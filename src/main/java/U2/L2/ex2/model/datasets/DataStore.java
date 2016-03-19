package U2.L2.ex2.model.datasets;

import java.util.Set;

/**
 * Created by Сергеева on 18.03.2016.
 */
public interface DataStore {
    //return null if no such user
    User getUser(String name);

    //if no users return empty collection (not null)
    Set<String> getUserNames();

    //if no accounts return empty collection (not null)
    Set<Account> getAccounts(User owner);

    //if no accounts return empty collection (not null)
    Set<Record> getRecords(Account account);

    void addUser(User user);

    void addAccount(User user, Account account);

    void addRecord(Account account, Record record);

    //return removed user or null if no such user
    User removeUser(User user);

    //return removed account or null
    Account removeAccount(User owner, Account account);

    //return removed Record or null
    Record removeRecord(Account account, Record record);

}
