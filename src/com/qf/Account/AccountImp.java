package com.qf.Account;

import com.qf.DB.DButil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountImp implements AccountApi {
    @Override
    public Account findAccount(String username, String password) {
        String sql = "select * from account where username=? and password=?";
        try {
            Connection con = DButil.getConnection();
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1,username);
            st.setString(2,password);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                String username2 = rs.getString("username");
                String password2 = rs.getString("password");
                int id2 = rs.getInt("id");
                Account account = new Account();
                account.setUsername(username2);
                account.setPassword(password2);
                account.setId(id2);
                return account;
            }
            DButil.closeConnection(con,rs,st);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List showAllAccount() {
        String sql = "select * from account";
        try {
            Connection con = DButil.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            List list = new ArrayList();
            while(rs.next()){
                list.add(new Account(rs.getInt("id"),rs.getString("username"),rs.getString("password")));
            }
            DButil.closeConnection(con,rs,st);
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
