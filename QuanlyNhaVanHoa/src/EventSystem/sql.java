package EventSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class sql {

    public static void insertEvent(String name, String hostName, String startTime, String endTime, int fee) throws SQLException, ClassNotFoundException{
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/ktpm";
        try (Connection con = DriverManager.getConnection(url, "root", "Hoanghuuphuc1415")) {
            String sql = "INSERT INTO ktpm.events (name,hostName, startTime, endTime, fee) VALUES (?, ?, ?, ?, ?)";

            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, name);
            pstmt.setString(2, hostName);
            pstmt.setString(3, startTime);
            pstmt.setString(4, endTime);
            pstmt.setInt(5,  fee);
            pstmt.execute();
        }
    }

    public static void updateInfras(String name, String hostName, String startTime, String endTime, int fee) throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ktpm", "root", "Hoanghuuphuc1415");
        String sql = "UPDATE ktpm.events SET "+
                "hostname = "+"'"+hostName+"', "+
                "startTime = "+"'"+startTime+"', "+
                "endTime = "+"'"+endTime+"', "+
                "fee = "+"'"+fee+"' "+
                "WHERE name = "+"'"+name+"';";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.executeUpdate();
        con.close();
    }

    public static void deleteInfras(String name) throws SQLException, ClassNotFoundException {

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ktpm", "root", "Hoanghuuphuc1415");
        String sql = "DELETE FROM ktpm.events WHERE name = '"+name+"';";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.executeUpdate();
        con.close();
        System.out.println("DELETED!");
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        insertEvent("Hoàng Huu PHúc", "Huy", "02/20/2001","02/01/2001" ,10000);
    }

}



