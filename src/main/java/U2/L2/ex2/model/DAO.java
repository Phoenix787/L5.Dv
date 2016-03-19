package U2.L2.ex2.model;

import U2.L2.ex2.model.datasets.Account;
import U2.L2.ex2.model.datasets.DataStore;
import U2.L2.ex2.model.datasets.Record;
import U2.L2.ex2.model.datasets.User;
import U2.L2.ex2.model.util.Executor;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Сергеева on 18.03.2016.
 *
 */
public class DAO implements DataStore {
    private Executor executor;


    public DAO(Connection connection) {
        this.executor = new Executor(connection);
    }


    @Override
    public User getUser(String name) {
        try {
            return executor.execQuery("Select * from users where name = '" + name + "';", result -> {
                result.next();
                return new User(result.getString("name"), result.getString("password"));
            });
        } catch (SQLException e) {
            // e.printStackTrace();
            return null;
        }
    }

    @Override
    public Set<String> getUserNames() {
        try {
            return executor.execQuery("Select name from users;", resultSet -> {
                //resultSet.next();
                Set<String> result = new HashSet<String>();
                while (resultSet.next()) {
                    result.add(resultSet.getString(1));
                }
                return result;
            });
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Set<Account> getAccounts(User owner) {
        return null;
    }

    @Override
    public Set<Record> getRecords(Account account) {
        return null;
    }

    @Override
    public void addUser(User user) {
        try {
            executor.execUpdate("insert into users(name, password) values('" + user.getName() + "', '" + user.getPassword() + "');");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addAccount(User user, Account account) {
        try {
            executor.execUpdate("insert into accounts(description, amount, id_user) values('"
                    + account.getDescription() + "', '"
                    + account.getAmount() + "', '"
                    + user.getId() + "');");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addRecord(Account account, Record record) {
        try {
            executor.execUpdate("insert into records(description, date, amount, id_account) values('"
                    + record.getDesc() + "', '"
                    + record.getDate() + "', '"
                    + record.getAmount() + "', '"
                    + account.getId() + "');");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User removeUser(User user) {
        try {
            if (getUser(user.getName()) != null) {
                executor.execUpdate("delete from users where name = '" + user.getName() + "'");
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Account removeAccount(User owner, Account account) {
        return null;
    }

    @Override
    public Record removeRecord(Account account, Record record) {
        return null;
    }

    public void createTable() {
        try {
            executor.execUpdate("create table if not exists users (id bigint auto_increment primary key, name varchar(256), password varchar(256))");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
