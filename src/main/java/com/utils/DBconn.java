package com.utils;

import java.sql.*;

public class DBconn {
    public static Connection conn = null;
    static ResultSet rs = null;
    static PreparedStatement ps = null;
    //数据连接初始化
    public static void init(){
        String url = "jdbc:mysql://localhost:3306/blog?useunicuee=true& characterEncoding=utf8";
        String username = "root";
        String password = "110637";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            System.out.println("数据库初始化失败");
            e.printStackTrace();
        }
    }
}
