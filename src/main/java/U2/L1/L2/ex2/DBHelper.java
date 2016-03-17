package U2.L1.L2.ex2;

import org.h2.jdbcx.JdbcDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Ксения on 17.03.2016.
 */
public class DBHelper {
    private static final Logger logger = LoggerFactory.getLogger(DBHelper.class);
    private Connection conn;
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
         *
         */
       // Class.forName(DATABASE_URL); //загружаем драйвер в память

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


}
