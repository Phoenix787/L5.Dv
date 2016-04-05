package U2.L2.fm.model.interfaces;

import U2.L2.fm.model.datasets.Account;
import U2.L2.fm.model.datasets.Category;
import U2.L2.fm.model.datasets.Record;

import java.util.Date;
import java.util.Set;

/**
 * Created by Ксения on 26.03.2016.
 */
public interface Manageable {
    boolean signIn(String login, String password);

    boolean signUp(String name, String password);

    Set<String> getUserNames();

    String getOwner();

    boolean addAccount(String username, String accountDesc, double amount);

    Set<Account> getAccounts(String owner);

    Account getAccount(String desc);

    boolean addRecord(Account account, String nameCategory, boolean type, Date date, double amount, String recordDesc);

    Set<Record> getRecords(Account account);

    Set<Category> getCategories();

    boolean addCategory(String text);
}
