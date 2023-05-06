package com.example.ecommerce;
import java.net.SocketOption;
import java.sql.*;
import java.util.Queue;

public class DbConnection {
    private final String dbUrl = "jdbc:mysql://localhost:3306/ecommerce";
    private final String userName = "root";
    private final String password = "Suraj@123";

    Statement getStatement(){
        try{
            Connection connection = DriverManager.getConnection(dbUrl,userName,password);
            return connection.createStatement();
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    ResultSet getQueryTable(String query){
        try{
            Statement statement = getStatement();
            return statement.executeQuery(query);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    int updateDatabase(String query){
        try{
            Statement statement = getStatement();
            return statement.executeUpdate(query);
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }

    public static void main(String[] args) {
            DbConnection conn = new DbConnection();
            ResultSet rs = conn.getQueryTable("SELECT * FROM customer");
            if(rs != null){
                System.out.println("Connection Successful");
            }else
            {
                System.out.println("Connection Failed");
            }
    }
}
