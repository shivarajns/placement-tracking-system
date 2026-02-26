package com.Uniplace.backend.Repository;

import com.Uniplace.backend.Model.StudentProfile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentProfileRepo extends JpaRepository<StudentProfile, Long> {


    Optional<StudentProfile> findByEmail(String email);
}
