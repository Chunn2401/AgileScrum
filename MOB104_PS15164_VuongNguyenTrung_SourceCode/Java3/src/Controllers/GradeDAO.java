/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.Grade;
import Database.DatabaseUtils;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;

public class GradeDAO {
    
    
    public List<Grade> getAllGrade() {
        List<Grade> ls = new ArrayList<>();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT STUDENTS.MASV, Hoten, Tienganh, Tinhoc, GDTC,(Tienganh + Tinhoc + GDTC)/3 AS DiemTB FROM GRADE, STUDENTS WHERE GRADE.MASV = STUDENTS.MASV ORDER BY MASV ASC";
            conn = DatabaseUtils.getDBConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Grade g = new Grade();
                g.setMaSV(rs.getString(1));
                g.setFullName(rs.getString(2));
                g.setAnhVan(rs.getInt(3));
                g.setTinHoc(rs.getInt(4));
                g.setGdtc(rs.getInt(5));
                
           
                ls.add(g);
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
    
    public List<Grade> getTop3Grade() {
        List<Grade> ls = new ArrayList<>();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT TOP 3 STUDENTS.MASV, Hoten, Tienganh, Tinhoc, GDTC,(Tienganh + Tinhoc + GDTC)/3 AS DiemTB FROM GRADE, STUDENTS WHERE GRADE.MASV = STUDENTS.MASV ORDER BY DiemTB DESC";
            conn = DatabaseUtils.getDBConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Grade g = new Grade();
                g.setMaSV(rs.getString(1));
                g.setFullName(rs.getString(2));
                g.setAnhVan(rs.getInt(3));
                g.setTinHoc(rs.getInt(4));
                g.setGdtc(rs.getInt(5));
           
                ls.add(g);
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
    
    public List<Grade> getGradeByHoten(String hoten) {
        List<Grade> ls = new ArrayList<>();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT dbo.GRADE.MASV, dbo.STUDENTS.Hoten, dbo.GRADE.Tienganh, dbo.GRADE.Tinhoc, dbo.GRADE.GDTC FROM dbo.GRADE INNER JOIN dbo.STUDENTS ON dbo.GRADE.MASV = dbo.STUDENTS.MASV WHERE dbo.STUDENTS.Hoten LIKE N'%"+ hoten +"%'";
            conn = DatabaseUtils.getDBConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Grade g = new Grade();
                g.setMaSV(rs.getString(1));
                g.setFullName(rs.getString(2));
                g.setAnhVan(rs.getInt(3));
                g.setTinHoc(rs.getInt(4));
                g.setGdtc(rs.getInt(5));
           
                ls.add(g);
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
    
    public List<Grade> getGradeGioi() {
        List<Grade> ls = new ArrayList<>();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT dbo.GRADE.MASV, dbo.STUDENTS.Hoten, dbo.GRADE.Tienganh, dbo.GRADE.Tinhoc, dbo.GRADE.GDTC FROM dbo.GRADE INNER JOIN dbo.STUDENTS ON dbo.GRADE.MASV = dbo.STUDENTS.MASV WHERE (dbo.GRADE.Tienganh + dbo.GRADE.Tinhoc + dbo.GRADE.GDTC)/3 BETWEEN 8 AND 10";
            conn = DatabaseUtils.getDBConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Grade g = new Grade();
                g.setMaSV(rs.getString(1));
                g.setFullName(rs.getString(2));
                g.setAnhVan(rs.getInt(3));
                g.setTinHoc(rs.getInt(4));
                g.setGdtc(rs.getInt(5));
           
                ls.add(g);
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
    
    public List<Grade> getGradeYeu() {
        List<Grade> ls = new ArrayList<>();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT dbo.GRADE.MASV, dbo.STUDENTS.Hoten, dbo.GRADE.Tienganh, dbo.GRADE.Tinhoc, dbo.GRADE.GDTC FROM dbo.GRADE INNER JOIN dbo.STUDENTS ON dbo.GRADE.MASV = dbo.STUDENTS.MASV WHERE (dbo.GRADE.Tienganh + dbo.GRADE.Tinhoc + dbo.GRADE.GDTC)/3 < 5";
            conn = DatabaseUtils.getDBConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Grade g = new Grade();
                g.setMaSV(rs.getString(1));
                g.setFullName(rs.getString(2));
                g.setAnhVan(rs.getInt(3));
                g.setTinHoc(rs.getInt(4));
                g.setGdtc(rs.getInt(5));
           
                ls.add(g);
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
    
    
    
    
    
    public boolean add(Grade g) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            String sql = "INSERT INTO GRADE(MASV,Tienganh,Tinhoc,GDTC) values (?,?,?,?)";
            conn = DatabaseUtils.getDBConnection();
            stmt = conn.prepareStatement(sql);

            stmt.setString(1, g.getMaSV().trim());
            stmt.setDouble(2, g.getAnhVan());
            stmt.setDouble(3, g.getTinHoc());
            stmt.setDouble(4, g.getGdtc());
            
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
    
    public boolean update(Grade g) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            String sql = "UPDATE GRADE SET MASV=?, Tienganh=?, Tinhoc=?, GDTC=? WHERE MASV=?";
            conn = DatabaseUtils.getDBConnection();
            stmt = conn.prepareStatement(sql);
            
            stmt.setString(1, g.getMaSV().trim());
            stmt.setDouble(2, g.getAnhVan());
            stmt.setDouble(3, g.getTinHoc());
            stmt.setDouble(4, g.getGdtc());
            stmt.setString(5, g.getMaSV().trim());

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
    
    public boolean delete(Grade g) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            String sql = "DELETE FROM GRADE WHERE MASV=?";
            conn = DatabaseUtils.getDBConnection();
            stmt = conn.prepareStatement(sql);

            stmt.setString(1, g.getMaSV().trim());

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

 
}
