package com.uniplace.repository;

import com.uniplace.model.StudentProfile;
import com.uniplace.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentProfileRepository extends JpaRepository<StudentProfile, Long> {

    // Find profile by user
    Optional<StudentProfile> findByUser(User user);
    Optional<StudentProfile> findByUsn(String usn);
}
