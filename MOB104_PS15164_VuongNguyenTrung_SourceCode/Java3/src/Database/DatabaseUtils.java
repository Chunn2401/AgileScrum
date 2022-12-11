/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;


import java.sql.Connection;
import java.sql.DriverManager;


/**
 *
 * @author trieu
 */
public class DatabaseUtils {
    public static final String url = "jdbc:sqlserver://localhost:1433;databaseName=Sof203;user=sa;password=dongtrieu";
    
    public static Connection getDBConnection(){
        
        try {
            Connection conn = null;
            conn = DriverManager.getConnection(url);
            return conn;
        } catch (Exception e) {
            System.out.println("Lỗi kết nối DB !");
            System.out.println(e);
        }
        return null;
    }
    
    
    //test kết nối DB
//    public static void main(String[] args) {
//        if(getDBConnection() != null){
//            System.out.println("Kết nối với DB thành công");
//        }
//        else{
//            System.out.println("Kết nối thất bại");
//        }
//    }
    
}
