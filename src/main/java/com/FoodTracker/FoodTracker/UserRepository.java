//package com.FoodTracker.FoodTracker;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//
//public interface UserRepository extends JpaRepository<User, Long> {
//    User findByEmail(String email);
//
//    @Query(value = "SELECT FROM users WHERE email = ?1",nativeQuery = true)
//    Long AiciVoiAveaId(String nume);
//}
