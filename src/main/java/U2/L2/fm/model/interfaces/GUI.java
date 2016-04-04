package U2.L2.fm.model.interfaces;

import U2.L2.fm.model.datasets.Account;
import U2.L2.fm.model.datasets.Record;

import java.util.List;
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


}
