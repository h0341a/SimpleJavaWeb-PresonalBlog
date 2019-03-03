package com.dao;

import com.entity.User;
import com.utils.DBconn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO  {
    public boolean register(User user){
        DBconn.init();
        try {
            String sql = "Insert into users(username, password)Values(?,?)";
            PreparedStatement pStatement = DBconn.conn.prepareStatement(sql);
            pStatement.setObject(1, user.getUsername());
            pStatement.setObject(2, user.getPassword());
            pStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public User login(User user){
        DBconn.init();
        try {
            String sql = "SELECT * FROM users WHERE username=?";
            PreparedStatement pStatement = DBconn.conn.prepareStatement(sql);
            pStatement.setObject(1, user.getUsername());
            ResultSet rs = pStatement.executeQuery();
            rs.next();
            if(rs.getString("password").equals(user.getPassword())){
                user.setUserId(rs.getInt("user_id"));
                return user;
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
