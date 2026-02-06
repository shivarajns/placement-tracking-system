package com.uniplace.service.imp;

import com.uniplace.dto.StudentProfileResponse;
import com.uniplace.exception.StudentProfileNotAvailableException;
import com.uniplace.model.StudentProfile;
import com.uniplace.repository.StudentProfileRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentProfileServiceImp {

    private final StudentProfileRepository studentProfileRepository;


    public StudentProfileServiceImp(StudentProfileRepository studentProfileRepository) {
        this.studentProfileRepository = studentProfileRepository;
    }

    public StudentProfileResponse getStudentProfileByUsn (String usn){
        StudentProfile profile = studentProfileRepository.findByUsn(usn)
                .orElseThrow(() -> new StudentProfileNotAvailableException("Student Profile Not Available"));

        StudentProfileResponse response = new StudentProfileResponse();

        response.setName(profile.getName());
        response.setUsn(profile.getUsn());
        response.setBranch(profile.getBranch());
        response.setInstituteId(profile.getInstituteId());
        response.setInstituteName(profile.getInstituteName());
        response.setIsComplete(profile.getProfileCompleted());

        return response;
    }
}
