package com.uniplace.repository;

import com.uniplace.model.AdminStudent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminStudentRepository extends JpaRepository <AdminStudent, Long> {
    Optional <AdminStudent> findByEmailAndUsnAndInstituteId(String email, String usn, String instituteID);
}
