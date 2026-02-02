package com.uniplace.repository;

import com.uniplace.model.user;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<user, Long> {

    Optional<user> findByEmail(String email);
    boolean existsByEmail(String email);
}
