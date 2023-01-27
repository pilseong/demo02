package com.example.demo02.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo02.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
  
  @Query("""
    SELECT u FROM User u WHERE u.username = :username
  """)
  Optional<User> findUserByUsername(String username);
}
