package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Database {

    public static Connection connect(){
        Connection conn = null;
        try {
            // db parameters
            String url = "jdbc:sqlite:E:/sqlite/DaysOfCode.db";
            // create a connection to the database
            conn = DriverManager.getConnection(url);

            System.out.println("Connection to SQLite has been established.");

        } catch (
                SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public static void insert (String lastTask){
        String sql = "INSERT INTO Table1(check1) VALUES(?)";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setString(1, lastTask);
            pstmt.executeUpdate();
            System.out.println("Correctly inserted to daysOfCode.db");
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
