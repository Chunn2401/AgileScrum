/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.Students;
import Database.DatabaseUtils;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
//import java.sql.DriverManager;
import java.sql.ResultSet;
//import java.sql.SQLDataException;
//import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;

/**
 *
 * @author trieu
 */
public class StudentsDAO {

    public boolean add(Students std) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            String sql = "INSERT INTO STUDENTS(MASV,Hoten,Email,SoDT,Gioitinh,Diachi,Hinh) values (?,?,?,?,?,?,?)";
            conn = DatabaseUtils.getDBConnection();
            stmt = conn.prepareStatement(sql);

            stmt.setString(1, std.getMaSV().trim());
            stmt.setString(2, std.getFullname().trim());
            stmt.setString(3, std.getEmail().trim());
            stmt.setString(4, std.getPhone().trim());
            stmt.setString(5, std.getSex().trim());
            stmt.setString(6, std.getAddress().trim());
            stmt.setString(7, std.getAvatar().trim());

            if (stmt.executeUpdate() > 0) {
                return true;
            }
        } catch (Exception e) {
        } finally {
            try {
                conn.close();
                stmt.close();
            } catch (Exception e) {
            }
        }
        return false;
    }

    public boolean update(Students std) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            String sql = "UPDATE STUDENTS SET Hoten=?, Email=?, SoDT=?, Gioitinh=?, Diachi=?, Hinh=? WHERE MASV=?";
            conn = DatabaseUtils.getDBConnection();
            stmt = conn.prepareStatement(sql);

            stmt.setString(1, std.getFullname().trim());
            stmt.setString(2, std.getEmail().trim());
            stmt.setString(3, std.getPhone().trim());
            stmt.setString(4, std.getSex().trim());
            stmt.setString(5, std.getAddress().trim());
            stmt.setString(6, std.getAvatar().trim());
            stmt.setString(7, std.getMaSV().trim());

            if (stmt.executeUpdate() > 0) {
                return true;
            }
        } catch (Exception e) {
        } finally {
            try {
                conn.close();
                stmt.close();
            } catch (Exception e) {
            }
        }
        return false;
    }

    public boolean delete(Students std) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            String sql = "DELETE FROM STUDENTS WHERE MASV=?";
            conn = DatabaseUtils.getDBConnection();
            stmt = conn.prepareStatement(sql);

            stmt.setString(1, std.getMaSV().trim());

            if (stmt.executeUpdate() > 0) {
                return true;
            }
        } catch (Exception e) {
        } finally {
            try {
                conn.close();
                stmt.close();
            } catch (Exception e) {
            }
        }
        return false;
    }

    public List<Students> getAllStudents() {
        List<Students> ls = new ArrayList<>();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT * FROM STUDENTS";
            conn = DatabaseUtils.getDBConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Students std = new Students();
                std.setMaSV(rs.getString("MaSV"));
                std.setFullname(rs.getString("Hoten"));
                std.setEmail(rs.getString("Email"));
                std.setPhone(rs.getString("SoDT"));
                String gioitinh = rs.getString("Gioitinh");
                if (gioitinh.equals("0")) {
                    std.setSex("Nam");
                } else {
                    std.setSex("Nữ");
                }
                std.setAddress(rs.getString("Diachi"));
                std.setAvatar(rs.getString("Hinh"));
                ls.add(std);
            }
        } catch (Exception e) {
        } finally {
            try {
                rs.close();
                conn.close();
                stmt.close();
            } catch (Exception e) {
            }
        }
        return ls;
    }
    
    public List<Students> getStudentsByHoten(String hoten) {
        List<Students> ls = new ArrayList<>();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT * FROM STUDENTS WHERE Hoten LIKE N'%"+ hoten +"%'";
            conn = DatabaseUtils.getDBConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Students std = new Students();
                std.setMaSV(rs.getString("MaSV"));
                std.setFullname(rs.getString("Hoten"));
                std.setEmail(rs.getString("Email"));
                std.setPhone(rs.getString("SoDT"));
                String gioitinh = rs.getString("Gioitinh");
                if (gioitinh.equals("0")) {
                    std.setSex("Nam");
                } else {
                    std.setSex("Nữ");
                }
                std.setAddress(rs.getString("Diachi"));
                std.setAvatar(rs.getString("Hinh"));
                ls.add(std);
            }
        } catch (Exception e) {
        } finally {
            try {
                rs.close();
                conn.close();
                stmt.close();
            } catch (Exception e) {
            }
        }
        return ls;
    }
    

}
