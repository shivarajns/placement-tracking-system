package com.Uniplace.backend.Service.Implementation;

import com.Uniplace.backend.DTO.StudentProfileResponse;
import com.Uniplace.backend.DTO.UpdateStudentProfileRequest;
import com.Uniplace.backend.Exceptions.ProfileNotFoundException;
import com.Uniplace.backend.Mapper.StudentProfileMapper;
import com.Uniplace.backend.Model.StudentProfile;
import com.Uniplace.backend.Repository.StudentProfileRepo;
import org.springframework.stereotype.Service;

@Service
public class StudentProfileService {

    public StudentProfileRepo studentRepo;
    public StudentProfileMapper studentMapper;

    public StudentProfileService(StudentProfileRepo studentRepo, StudentProfileMapper studentMapper){
        this.studentRepo = studentRepo;
        this.studentMapper = studentMapper;
    }

    public StudentProfileResponse getProfile(String email){
        StudentProfile studentProfile = studentRepo.findByEmail(email)
                .orElseThrow(()->new ProfileNotFoundException("Profile not found"));
        return studentMapper.toResponse(studentProfile);
    }

    public StudentProfileResponse updateStudentProfile(String email, UpdateStudentProfileRequest request){
        StudentProfile studentProfile = studentRepo.findByEmail(email)
                .orElseThrow(()-> new ProfileNotFoundException("Profile not found"));

        studentMapper.updateStudentProfile(studentProfile, request);
        studentRepo.save(studentProfile);
        return studentMapper.toResponse(studentProfile);
    }
}
