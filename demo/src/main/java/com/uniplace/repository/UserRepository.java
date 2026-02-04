package com.uniplace.repository;

import com.uniplace.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // Check if email already registered
    boolean existsByEmail(String email);

    // Optional: find by email for login
    User findByEmail(String email);
}
