package ManagerInfrastructure;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class sql {
    public static void insertInfras(String name,int count, String cf, String lc, String date, String insu) throws SQLException, ClassNotFoundException{
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/ktpm";
        try (Connection con = DriverManager.getConnection(url, "root", "huy123")) {
            String sql = "INSERT INTO infras (name, count, importFrom, location, dateImport, insurance) VALUES (?, ?, ?, ?, ?, ?);";

            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, name);
            pstmt.setInt(2, count);
            pstmt.setString(3, cf);
            pstmt.setString(4, lc);
            pstmt.setString(5, date);
            pstmt.setString(6, insu);
            pstmt.execute();
        }
    }

    public static void updateInfras(String name,int count, String cf, String lc, String date, String insu) throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ktpm", "root", "huy123");
        String sql1 = "UPDATE user_info SET address = 'VietNam' WHERE address = 'England';";
        String sql = "UPDATE infras SET "+
                "count = "+"'"+count+"', "+
                "importFrom = "+"'"+cf+"', "+
                "location = "+"'"+lc+"', "+
                "dateImport = "+"'"+date+"', "+
                "insurance = "+"'"+insu+"' "+
                "WHERE name = "+"'"+name+"';";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.executeUpdate();
        con.close();
    }

    public static void deleteInfras(String name) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ktpm", "root", "huy123");
        String sql = "DELETE FROM infras WHERE name = '"+name+"';";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.executeUpdate();
        con.close();
        System.out.println("DELETED!");
    }
}

class test{
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        sql.deleteInfras("Bui Van Huy");
    }
}