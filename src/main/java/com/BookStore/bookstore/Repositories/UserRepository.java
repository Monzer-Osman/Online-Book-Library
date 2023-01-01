package com.BookStore.bookstore.Repositories;

import com.BookStore.bookstore.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository
        extends JpaRepository<User, Integer> {
      @Query(value = "SELECT * FROM users WHERE email = ?1", nativeQuery = true)
      public User findByEmailAddress(String email);
}
