package devoir.core.DatasBase.impl;

import java.sql.*;


import devoir.core.DatasBase.DatasBase;

public class DatasBaseImpl implements DatasBase{
    protected Connection conn = null;
    protected PreparedStatement ps = null;
    private String url = "jdbc:mysql://localhost/gestion_rv";
    private String user = "root";
    private String password = "";

    @Override
    public void getConnexion() throws SQLException {
         if (this.conn ==null) {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    conn = DriverManager.getConnection(this.url, this.user, this.password);
                } catch (ClassNotFoundException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
        }
    }

    @Override
    public void closeConenxion() throws SQLException {
        if(this.conn !=null && !this.conn.isClosed()){
            conn.close();
        }
    }

    @Override
    public ResultSet executeQuery() throws SQLException {
        return this.ps.executeQuery();
    }

    @Override
    public int executeUpdate() throws SQLException {
        return this.ps.executeUpdate();
    }
    
}
