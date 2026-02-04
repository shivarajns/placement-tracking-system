package com.uniplace.repository;

import com.uniplace.model.AdminStudent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdminStudentRepository extends JpaRepository<AdminStudent, Long> {

    // Check if a student exists in admin DB
    Optional<AdminStudent> findByEmailAndUsnAndInstituteId(
            String email,
            String usn,
            String instituteId
    );
}
