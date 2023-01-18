package repository;

import models.MenuItem;
import repository.base.BaseRepository;

import java.io.Console;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MenuItemRepository extends BaseRepository {
    public ArrayList<MenuItem> GetAllMenuItemsForRestaurant(int RestaurantId) {
        try {
            ResultSet rs = mConnection.ExecuteSimpleQuery(String.format("SELECT * FROM menu_items WHERE restaurantId=%d", RestaurantId));
            ArrayList<MenuItem> resultItems = new ArrayList<>();

            while (rs.next()) {
                MenuItem item = new MenuItem();

                item.Id = rs.getInt("id");
                item.RestaurantId = RestaurantId;
                item.Name = rs.getString("name");
                item.Description = rs.getString("description");
                item.PictureUrl = rs.getString("pictureUrl");

                resultItems.add(item);
            }

            return resultItems;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public boolean CreateMenuItemForRestaurant(MenuItem Data, int RestaurantId) {
        try {
            PreparedStatement ps = mConnection.NewPreparedStatement("INSERT INTO menu_items(restaurantId, name, description, pictureUrl) VALUES(?,?,?,?)");

            ps.setInt(1, RestaurantId);
            ps.setString(2, Data.Name);
            ps.setString(3, Data.Description);
            ps.setString(4, Data.PictureUrl);

            return 0 < ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return false;
    }
}
