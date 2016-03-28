package U2.L2.fm.model;

import U2.L2.fm.model.datasets.Account;
import U2.L2.fm.model.datasets.Category;
import U2.L2.fm.model.datasets.Record;
import U2.L2.fm.model.datasets.User;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.util.List;


public class DBService {
    private final static String hibernate_show_sql = "true";
    private final static String hbm2ddl_auto = "update";

    private final SessionFactory sessionFactory;

    public DBService() {
        Configuration configuration = getH2Configuration();
        this.sessionFactory = createSessionFactory(configuration);
    }

    /*------------CONFIGURATION ----------------------------------------*/
    private Configuration getH2Configuration() {
        Configuration configuration = new Configuration();

        configuration.addAnnotatedClass(User.class);
        configuration.addAnnotatedClass(Account.class);
        configuration.addAnnotatedClass(Record.class);
        configuration.addAnnotatedClass(Category.class);

        configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
        configuration.setProperty("hibernate.connection.driver_class", "org.h2.Driver");
        configuration.setProperty("hibernate.connection.url", "jdbc:h2:./h2db");
        configuration.setProperty("hibernate.connection.username", "tully");
        configuration.setProperty("hibernate.connection.password", "tully");
        configuration.setProperty("hibernate.show_sql", hibernate_show_sql);
        configuration.setProperty("hibernate.hbm2dll.auto", hbm2ddl_auto);

        return configuration;
    }

    private SessionFactory createSessionFactory(Configuration configuration) {
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
        builder.applySettings(configuration.getProperties());
        ServiceRegistry serviceRegistry = builder.build();
        return configuration.buildSessionFactory(serviceRegistry);
    }

    /*  CRUD-methods  */

    public void addUser(String name, String password) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        DAOImpl dao = new DAOImpl(session);
        dao.addUser(new User(name, password));
        transaction.commit();
        session.close();
    }

    public void updateUser(String name, String password) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        DAOImpl dao = new DAOImpl(session);
        dao.updateUser(new User(name, password));
        session.getTransaction().commit();
        session.close();
    }

    public User getUser(String name) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        DAOImpl dao = new DAOImpl(session);
        User user = dao.getUser(name);
        session.getTransaction().commit();
        session.close();
        return user;
    }

    public void addAccount(User user, Account account) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        DAOImpl dao = new DAOImpl(session);
        dao.addAccount(user, account);
        session.getTransaction().commit();
        session.close();
    }

    public List<Account> getAccounts() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<Account> result = session.createQuery("from Account order by description").list();
        for (Account account : result) {
            Hibernate.initialize(account.getRecords());
        }
        return result;
    }

    public void addRecord(Account account, Record record) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        DAOImpl dao = new DAOImpl(session);
        dao.addRecord(account, record);
        session.getTransaction().commit();
        session.close();
    }

    public List<Record> getRecords(){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<Record> result = session.createQuery("from Record order by recordName").list();
        for (Record record : result) {
            Hibernate.initialize(record.getCategory());
        }
        return result;
    }

    public Record getRecord(Long account_id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Record result = (Record) session.load(Record.class, account_id);
        Hibernate.initialize(result.getCategory());
        return result;
    }




}
