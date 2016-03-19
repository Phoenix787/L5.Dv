package U2.L2.fm.model.util;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Сергеева on 18.03.2016.
 */
public interface ResultHelper<T> {
    T handle(ResultSet resultSet) throws SQLException;
}
