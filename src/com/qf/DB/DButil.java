package com.qf.DB;

import java.sql.*;

public class DButil {
    static private String url = DBconfig.getValue("url");
    static private String username = DBconfig.getValue("username");
    static private String password = DBconfig.getValue("password");
    static private String driver = DBconfig.getValue("driver");
    static {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url,username,password);
    }

    public static void closeConnection(Connection con, ResultSet rs,Statement st){
        try {
            if (con!=null){
                con.close();
            }
            if (rs!=null){
                rs.close();
            }
            if (st!=null){
                st.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
