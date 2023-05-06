package com.example.ecommerce;

import javafx.collections.ObservableList;

import java.sql.ResultSet;

public class Order {
    public static boolean placeOrder(Customer customer,Product product){
        String groupOrderId = "select max(group_order_id)+1 id from orders";
        DbConnection dbConnection = new DbConnection();
        try {
            ResultSet rs = dbConnection.getQueryTable(groupOrderId);
            if(rs.next()){
                String placeOrder = "insert into orders(group_order_id,customer_id,product_id)"+ "values ("+rs.getInt("id")+","+customer.getId()+","+product.getId()+")";
                return dbConnection.updateDatabase(placeOrder)!=0;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    static int placeMultipleOrder(Customer customer, ObservableList<Product> productList){
        String groupOrderId = "SELECT max(group_order_id)+1 id FROM orders";

        try {
            DbConnection dbConnection = new DbConnection();
            ResultSet rs = dbConnection.getQueryTable(groupOrderId);
            int count = 0;
            if(rs.next()){
                for (Product product : productList ){
                    String placeOrder = "INSERT INTO orders(group_order_id,customer_id)"+" VALUES("+rs.getInt("id")+","+customer.getId()+","+product.getId()+")";
                    count += dbConnection.updateDatabase(placeOrder);
                }
                return count;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }
}
