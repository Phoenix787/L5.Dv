package U2.L2.ex2.controller;

import U2.L2.ex2.model.DAO;
import U2.L2.ex2.model.datasets.DataStore;
import U2.L2.ex2.model.datasets.User;
import org.h2.jdbcx.JdbcDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Set;

/**
 * Created by Ксения on 17.03.2016.
 *
 */
public class DBHelper {
    private static final Logger logger = LoggerFactory.getLogger(DBHelper.class);
    private static Connection conn;
    private static DBHelper dbHelper;
    private static final String DATABASE_URL = "jdbc:h2:./h2db";

    public static DBHelper getInstance(){
        if (dbHelper == null) {
            dbHelper = new DBHelper();
        }
        return dbHelper;
    }
//синглтон не идеальный, нет многопоточности, нет двойной проверки
    private DBHelper(){
        logger.info("Opening database: {}", DATABASE_URL);
        conn = getH2Connection();

    }

    private Connection getH2Connection() {
        /**
         * Class.forName - механизм рефлекшен, т е механизм работы в java непосредственно с откомпилированными файлами
         *  Class.forName(DATABASE_URL); //загружаем драйвер в память - альтернативный метод DriverManager
         */
       try {
            String name = "tully";
            String password = "tully";
            JdbcDataSource ds = new JdbcDataSource();
            ds.setUrl(DATABASE_URL);
            ds.setUser(name);
            ds.setPassword(password);

            return DriverManager.getConnection(DATABASE_URL, name, password);
        } catch (SQLException e) {
            logger.error("Can not connect to db. ");
        }
        return null;
    }



    public void addUser(User user){

        DataStore dao = new DAO(conn);

        dao.addUser(user);
        logger.info("Add new user with name: {}", user.getName());
        //return dao.getUser(user.getName()).getId();
    }

    public User getUser(String name) {
        DAO dao = new DAO(conn);
        return dao.getUser(name);
    }

    public Set<String> getUserNames(){
        DAO dao = new DAO(conn);
        return dao.getUserNames();
    }

    public void createTable(){
        DAO dao = new DAO(conn);
        dao.createTable();

    }

    public User removeUser(String name){
        DAO dao = new DAO(conn);
        User user = dao.getUser(name);
        return dao.removeUser(user);
    }

    private static void closeResource(AutoCloseable res) {
        try {
            if (res != null) {
                res.close();
                res = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void closeConnection(){
        closeResource(conn);
        conn = null;
    }


}
