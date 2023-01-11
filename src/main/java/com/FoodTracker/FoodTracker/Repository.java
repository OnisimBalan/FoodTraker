package com.FoodTracker.FoodTracker;
import java.sql.*;
import java.sql.SQLException;
import java.sql.DriverManager;

import static java.sql.DriverManager.getConnection;

public class Repository{
    void connection(){
        try{
                String url = "jdbc:mysql://localhost:3306/foodtracker";
                String user="root";
                String password = "";
                Class.forName("com.mysql.jdbc.Driver");
                Connection connection  = getConnection(url,user,password);

                // Create a statement object
                Statement statement = connection.createStatement();
            Statement stmt = connection.createStatement();

                // Execute a SELECT statement
                String query = "SELECT * FROM restaurant";
                ResultSet rs = stmt.executeQuery(query);

                // Iterate over the results
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String nume = rs.getString("nume");
                    String descriere = rs.getString("descriere");

                    System.out.println("ID: " + id + ", Nume: " + nume  +", Descriere:"+ descriere);
                }
           String query2 = "INSERT INTO restaurant (id, nume, adresa, descriere, meniu) VALUES (?,?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(query2);

               ///Bind the values to the placeholders
            ps.setString(3, "value1");
            ps.setString(2, "value2");
            ps.setString(4, "value3");
            ps.setString(5, "value4");
            ps.setInt(1, 10);


            // Execute the INSERT statement
            int rows = ps.executeUpdate();
            System.out.println("Rows inserted: " + rows);

                // Close the ResultSet, statement, and connection
                rs.close();
                stmt.close();
                connection.close();

                System.out.println("Connection is successful to the database"+url);
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
        catch(SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
