package com.example.ecommerce;

import java.sql.ResultSet;

public class Login {
    public Customer customerLogin(String userName,String password){
        String LoginQuery = "SELECT * FROM customer WHERE email = '"+ userName +"' AND password = '"+password +"'";
        DbConnection conn = new DbConnection();
        ResultSet rs = conn.getQueryTable(LoginQuery);
        try{
                if(rs.next())
                 return new Customer(rs.getInt("id"),rs.getString("name"),rs.getString("email"),rs.getString("mobile"));

        }
        catch (Exception e){
            e.printStackTrace();
        }
       return null;
        }

    public static void main(String[] args) {
        Login login = new Login();
        Customer customer =login.customerLogin("kokitkar.suraj5@gmail.com","sk123");
        System.out.println("Welcome :" +customer.getName());

    }
}

