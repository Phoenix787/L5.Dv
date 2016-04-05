package U2.L2.fm.model.interfaces;

import U2.L2.fm.model.datasets.Account;
import U2.L2.fm.model.datasets.Category;
import U2.L2.fm.model.datasets.Record;

import java.util.Date;
import java.util.Set;

/**
 * Created by Ксения on 18.03.2016.
 */
public interface GUI {
    boolean authenticate(String username, String password);

    boolean register(String username, String password);

    Set<String> getNames();

    String getOwner();

    boolean addAccount(String username, String accountDesc, double amount);

    Set<Account> getAccounts(String owner);

    Set<Record> getRecords(Account account);

    Account getAccount(String desc);

    String[] updateListAccount();

    Set<Category> getCategories();


    boolean addCategory(String text);

    boolean addRecord(Account account, String nameCategory, Date date, Double amount, Boolean checked, String recDesc);
}
