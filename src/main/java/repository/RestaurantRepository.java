package repository;

import models.Image;
import models.MenuItem;
import models.RestaurantModel;
import repository.base.BaseRepository;

import javax.xml.transform.Result;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RestaurantRepository extends BaseRepository {
    public RestaurantModel GetSingleRestaurant(int Id) {
        try {
            ResultSet rs = mConnection.ExecuteSimpleQuery(String.format("SELECT * FROM restaurant WHERE id=%d", Id));
            if (rs.next()) {
                RestaurantModel restaurant = new RestaurantModel();

                restaurant.Id = Id;
                restaurant.Name = rs.getString("nume");
                restaurant.Address = rs.getString("adresa");
                restaurant.Description = rs.getString("descriere");
                restaurant.Description = rs.getString("imagine");

                return restaurant;
            }
        } catch (SQLException e) {
        }

        return null;
    }

    public ArrayList<RestaurantModel>  GetAllRestaurant() {
        try {
            ResultSet rs = mConnection.ExecuteSimpleQuery(String.format("SELECT * FROM restaurant"));
            ArrayList<RestaurantModel> restaurants = new ArrayList<>();

            while (rs.next()) {
                RestaurantModel restaurant = new RestaurantModel();

                restaurant.Id = rs.getInt("id");;
                restaurant.Name = rs.getString("nume");
                restaurant.Address = rs.getString("adresa");
                restaurant.Description = rs.getString("descriere");
                restaurant.Image = rs.getString("imagine");

                restaurants.add(restaurant);

            }
            return restaurants;
        } catch (SQLException e) {
        }

        return null;
    }

    public RestaurantModel CreateRestaurant(RestaurantModel Data) {
        try {
            PreparedStatement ps = mConnection.NewPreparedStatementForCreate("INSERT INTO restaurant(nume, adresa, descriere, imagine) VALUES(?,?,?,?)");

            ps.setString(1, Data.Name);
            ps.setString(2, Data.Address);
            ps.setString(3, Data.Description);
            ps.setString(4, Data.Image);
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next())
            {
                int newId = rs.getInt(1);
                return GetSingleRestaurant(newId);
            }
        } catch (SQLException e) {
        }

        return null;
    }
}
