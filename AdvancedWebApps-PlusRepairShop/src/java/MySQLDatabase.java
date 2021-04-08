
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author yoooo
 */
public class MySQLDatabase {

    public Connection getConnection() throws ClassNotFoundException, SQLException {

        final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
        final String DB_URL = "jdbc:mysql://localhost/plus_repair_shop_repairs";

        //  Database credentials
        final String USER = "root";
        final String PASS = "admin";

        Class.forName(JDBC_DRIVER);

        Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);

        return conn;
    }

    public int insertIntoRepairs(String Computer_Owner, String Computer_Serial_Number,
            String Type, String Model, int Memory_GB, int HardDisk_GB, String Problems) throws ClassNotFoundException, SQLException {

        Connection conn = getConnection();
        String sql = "INSERT INTO repairs (Computer_Owner, Computer_Serial_Number, Type, "
                + "Model, Memory_GB, HardDisk_GB, Problems, Repair_Delivery_DateTime) "
                + "VALUES (?, ?, ?, ?, ?, ?, "
                + "?, NOW())";   //NOW())";

        PreparedStatement pSt = conn.prepareStatement(sql);

        pSt.setString(1, Computer_Owner);                     // 1 specifies the first parameter in the query  
        pSt.setString(2, Computer_Serial_Number);             // 2 specifies the second parameter in the query
        pSt.setString(3, Type);
        pSt.setString(4, Model);
        pSt.setInt(5, Memory_GB);
        pSt.setInt(6, HardDisk_GB);
        pSt.setString(7, Problems);
        
        int rValue = pSt.executeUpdate();
        
        conn.close();
        pSt.close();

        return rValue;

    }
    
     public int insertIntoFeedbacks(String Name, String Country,
            String Phone, String Email, String Subject, String Type, String Message) throws ClassNotFoundException, SQLException {

        Connection conn = getConnection();
        String sql = "INSERT INTO Feedbacks (Name, Country, Phone, "
                + "Email, Subject, Type, Message, CreationDateTime) "
                + "VALUES (?, ?, ?, ?, ?, ?, "
                + "?, NOW())";   //NOW())";

        PreparedStatement pSt = conn.prepareStatement(sql);

        pSt.setString(1, Name);                     // 1 specifies the first parameter in the query  
        pSt.setString(2, Country);             // 2 specifies the second parameter in the query
        pSt.setString(3, Phone);
        pSt.setString(4, Email);
        pSt.setString(5, Subject);
        pSt.setString(6, Type);
        pSt.setString(7, Message);
        
        int rValue = pSt.executeUpdate();
        
        conn.close();
        pSt.close();

        return rValue;

    }
}
