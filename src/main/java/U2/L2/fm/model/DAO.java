package U2.L2.fm.model;

import U2.L2.fm.model.datasets.Account;
import U2.L2.fm.model.datasets.DataStore;
import U2.L2.fm.model.datasets.Record;
import U2.L2.fm.model.datasets.User;
import U2.L2.fm.model.util.Executor;

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
        try{
            return executor.execQuery("Select * from accounts where id_user = '" + owner.getId() +"';", resultSet -> {
                Set<Account> result = new HashSet<>();
                while (resultSet.next()) {
                    result.add(new Account(resultSet.getInt("id"), resultSet.getString("description"), resultSet.getDouble("amount")));
                }
                return result;
            });
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return null;
    }

    public Account getAccount(String description){
           try {
                return executor.execQuery("Select * from accounts where description = '" + description + "';", resultSet -> {
                    resultSet.next();
                    return new Account(resultSet.getInt("id"), resultSet.getString("description"), resultSet.getDouble("amount"));
                });
            } catch (SQLException e) {
                e.printStackTrace();
            }
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
        try{
            executor.execUpdate("delete from accounts where id_user = '" + owner.getId() + "' and id = '" + account.getId() + "'");
            return account;
        } catch (SQLException e) {
            e.printStackTrace();
        }

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
    public void createTables() {
        try {
            executor.execUpdate("create table if not exists users (id bigint auto_increment primary key, name varchar(256), password varchar(256));" +
                    "create table if not exists accounts(id bigint auto_increment  primary key, description varchar(256), amount double, id_user bigint, id_record bigint);" +
                    "create table if not exists records(id bigint auto_increment primary key, description varchar(256), amount double, date_rec date, id_category bigint, type boolean, id_account bigint);" +
                    "create table if not exists category(id bigint auto_increment primary key, name varchar(256));");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
