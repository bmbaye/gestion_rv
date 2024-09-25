package devoir.core.DatasBase;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface DatasBase {
     void getConnexion() throws SQLException;
     void closeConenxion() throws SQLException;
     ResultSet executeQuery() throws SQLException;
    int executeUpdate() throws SQLException;
}
