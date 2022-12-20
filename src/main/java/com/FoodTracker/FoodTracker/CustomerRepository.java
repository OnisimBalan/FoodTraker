package com.FoodTracker.FoodTracker;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Utilizator, Long> {
}
