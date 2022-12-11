/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.User;
import Database.DatabaseUtils;
import java.awt.List;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;

/**
 *
 * @author trieu
 */
public class UserDAO {


    //Kiểm tra username có tồn tại trong bảng USERS
    //Để tránh bị tấn công SQL Injection em dùng Statement để kiểm tra
    public User getUserByUsername(String username) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        User u = new User();
        try {
            String sql = "SELECT * FROM USERS WHERE username=?";
            conn = DatabaseUtils.getDBConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            rs=stmt.executeQuery();

            boolean flag = false;
            while (rs.next()) {
                u.setUsername( rs.getString(1));
                u.setPassword(rs.getString(2));
                u.setRole(rs.getString(3));
                return u;
            }
        } catch (Exception e) {
        }finally{
            try {
                conn.close();
                stmt.close();
                rs.close();
            } catch (Exception e) {
            }
        }
        return null;
    }
    
    //kiểm tra user,pass nếu user tồn tại 
    public boolean checkLogin(String username, String password){
        User user = getUserByUsername(username);
        if(user!=null){
            if(user.getPassword().equals(password)){
                return true;
            }
        }
        return false;
    }
    //kiểm tra quyền của user
    public String getRole(String username){
        User user = getUserByUsername(username);
        if(user!=null){
            String role=user.getRole();
            return role;
        }     
        return null;
    } 

}
