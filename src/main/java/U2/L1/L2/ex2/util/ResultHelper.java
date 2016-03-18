package U2.L1.L2.ex2.util;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Сергеева on 18.03.2016.
 */
public interface ResultHelper<T> {
    T handle(ResultSet resultSet) throws SQLException;
}
