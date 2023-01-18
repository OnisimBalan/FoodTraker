package com.FoodTracker.FoodTracker.controller;
import com.FoodTracker.FoodTracker.controller.models.CreateMenuItemModel;
import com.FoodTracker.FoodTracker.controller.models.CreateRestaurantModel;
import jakarta.persistence.metamodel.SetAttribute;
import models.Image;
import models.MenuItem;
import models.RestaurantModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.*;
import org.springframework.web.*;
import repository.MenuItemRepository;
import repository.RestaurantRepository;
import java.io.*;
import java.util.*;

@RestController
public class RestaurantController {
    @GetMapping("/getMenuItems")
    public ArrayList<MenuItem> GetRestaurantsItems(@RequestBody int restaurantId) {
        MenuItemRepository repo = new MenuItemRepository();
        return repo.GetAllMenuItemsForRestaurant(restaurantId);
    }

    @PostMapping("/createRestaurant")
    public String CreateRestaurant(@RequestBody RestaurantModel data) {
        RestaurantRepository repo = new RestaurantRepository();
        RestaurantModel restaurant = new RestaurantModel();
        restaurant.Name = data.Name;
        restaurant.Address = data.Address;
        restaurant.Description = data.Description;
        restaurant.Image = data.Image;
        repo.CreateRestaurant(restaurant);

        return "Restaurant created";
    }

     @GetMapping("/getRestaurants")
     public ArrayList<RestaurantModel> GetRestaurants() {
         RestaurantRepository repo = new RestaurantRepository();
         ArrayList<RestaurantModel> restaurants = new ArrayList<>();
         restaurants = repo.GetAllRestaurant();
         return restaurants;
     }
}


