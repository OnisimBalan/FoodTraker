package com.FoodTracker.FoodTracker;
import java.sql.*;
import java.sql.SQLException;
import java.sql.DriverManager;
public class Repository{
    void connection(){
        try{
            String url = "jdbc:mysql://localhost:3306/test";
            String user="root";
            String password = "";
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection  = DriverManager.getConnection(url,user,password);
            System.out.println("Connection is successful to the database"+url);
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
        catch(SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    void insert(){

    }

}
