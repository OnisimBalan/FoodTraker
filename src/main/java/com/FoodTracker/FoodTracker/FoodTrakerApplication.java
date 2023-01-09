package com.FoodTracker.FoodTracker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FoodTrakerApplication {
	public static void main(String[] args) {
		Repository repository = new Repository();
		SpringApplication.run(FoodTrakerApplication.class, args);
		repository.connection();
	}
}
