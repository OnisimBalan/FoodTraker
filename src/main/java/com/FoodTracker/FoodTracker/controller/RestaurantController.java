package com.FoodTracker.FoodTracker.controller;
import com.FoodTracker.FoodTracker.controller.models.CreateMenuItemModel;
import com.FoodTracker.FoodTracker.controller.models.CreateRestaurantModel;
import models.Image;
import models.MenuItem;
import models.RestaurantModel;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.*;
import org.springframework.web.*;
import repository.MenuItemRepository;
import repository.RestaurantRepository;
import java.io.*;
import java.util.*;

@RestController
@RequestMapping(path = "/restaurant")
public class RestaurantController {
    @GetMapping(path = "/getMenuItems")
    public ArrayList<MenuItem> GetRestaurantsItems(@RequestBody int restaurantId) {
        MenuItemRepository repo = new MenuItemRepository();
        return repo.GetAllMenuItemsForRestaurant(restaurantId);
    }

   //create a new restaurant in the database
    @PostMapping(path = "/createRestaurant")
    public RestaurantModel CreateRestaurant(@RequestBody CreateRestaurantModel data) {
        RestaurantRepository repo = new RestaurantRepository();
        RestaurantModel restaurant = new RestaurantModel();
        restaurant.Name = data.Name;
        restaurant.Address = data.Address;
        restaurant.Description = data.Description;
        return repo.CreateRestaurant(restaurant);
    }

     @GetMapping(path = "/getRestaurants")
     public ArrayList<RestaurantModel> GetRestaurants() {
         RestaurantRepository repo = new RestaurantRepository();
         return repo.GetAllRestaurant();
     }
    @PostMapping(path = "/createMenuItem")
    public boolean CreateMenuItem(@RequestBody CreateMenuItemModel data) {
        MenuItemRepository repo = new MenuItemRepository();
        return repo.CreateMenuItemForRestaurant(data, data.RestaurantId);
    }


    @PostMapping("/upload")
    public void handleFileUpload(@RequestParam("image") MultipartFile file) {
        // Handle the file upload
        // Move the image to a specific folder
        moveImageToFolder(file);
        // Store the path in the database
        storeImagePathInDb(file.getOriginalFilename());
    }
    private void moveImageToFolder(MultipartFile file) {
        try {
            String fileName = file.getOriginalFilename();
            String filePath = "path/to/folder/" + fileName;
            File destinationFile = new File(filePath);
            file.transferTo(destinationFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void storeImagePathInDb(String fileName) {
        // Use a database repository to store the file path
        Image image = new Image();
        image.setFileName(fileName);
        imageRepository.save(image);
    }



}


