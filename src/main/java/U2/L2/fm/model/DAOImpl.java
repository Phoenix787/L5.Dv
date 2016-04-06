package U2.L2.fm.model;

import U2.L2.fm.model.datasets.Account;
import U2.L2.fm.model.datasets.Category;
import U2.L2.fm.model.datasets.Record;
import U2.L2.fm.model.datasets.User;
import U2.L2.fm.model.interfaces.DataStore;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class DAOImpl implements DataStore {
    private Session session;

    public DAOImpl(Session session) {
        this.session = session;
    }

    @Override
    public User getUser(String name) {
        Criteria criteria = session.createCriteria(User.class);
        return (User)criteria.add(Restrictions.eq("name", name)).uniqueResult();
    }

    @Override
    @SuppressWarnings("Unchecked cast")
    public Set<String> getUserNames() {
        Criteria criteria = session.createCriteria(User.class);
        List<User>list = (List<User>) criteria.list();

        //все следующие строчки можно заменить следующим лямбда выражением
        // list.stream().map(User::getName).collect(Collectors.toSet());
        Set<String> result = new HashSet<>();
        for (User user : list) {
            result.add(user.getName());
        }
        return result;
    }

    @Override
    @SuppressWarnings("Unchecked cast")
    public Set<Account> getAccounts(User owner) {
        //Criteria criteria = session.createCriteria(Account.class);
//        List<Account> list = (List<Account>)criteria.list();
//        Set<Account> result = new HashSet<>();
//        result.addAll(list);
//        return result;
        //(Set<Account>)criteria.add(Restrictions.eq("user_id", owner.getUserId())).uniqueResult()
        List<Account> result = session.createQuery("from Account where user_id = " + owner.getUserId() + "order by description").list();
        for (Account account : result) {
            Hibernate.initialize(account.getRecords());
        }
        return new HashSet<>(result);
    }

    public Account getAccount(String desc) {

        Account result = (Account) session.createQuery("from Account where description = '" + desc + "'").uniqueResult();
        return result;
    }

    @Override
    @SuppressWarnings("Unchecked cast")
    public Set<Record> getRecords(Account account) {
//        Criteria criteria = session.createCriteria(Record.class);
//
//        return (Set<Record>)criteria.add(Restrictions.eq("account_id",account.getAccountId())).uniqueResult();
        List<Record> result = session.createQuery("from Record where account_id = " + account.getAccountId() + "order by recordName").list();
        for (Record record : result) {
            Hibernate.initialize(record.getCategory());
        }
        return new HashSet<>(result);
    }

    public Record getRecord(Long accountId) {
        return (Record) session.get(Record.class, accountId);
    }

    @Override
    public void addUser(User user) {
        try {
            session.save(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateUser(User user) {
        try {
            session.saveOrUpdate(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addAccount(User user, Account account) {
        try {
            account.setUser(user);
            session.save(account);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateAccount(User user, Account account) {
        try {
            session.saveOrUpdate(account);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void addRecord(Account account, Record record) {
        try {
            record.setAccount(account);

            session.persist(record);
            //account.getRecords().add(record);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public User removeUser(User user) {
        session.delete(user);
        return user;
    }

    @Override
    public Account removeAccount(User owner, Account account) {
        owner.getAccounts().remove(account);
        session.delete(account);
        return account;
    }

    @Override
    public Record removeRecord(Account account, Record record) {
        account.getRecords().remove(record);
        session.delete(record);
        return record;
    }


    public void addCategory(Category category) {
        try {
            session.save(category);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Category> getCategories(){
        return session.createQuery("from Category order by nameCategory").list();
    }

    public Category getCategory(String nameCategory) {
        return (Category)session.createQuery("from Category where nameCategory = '" + nameCategory + "'").uniqueResult();
    }
}
