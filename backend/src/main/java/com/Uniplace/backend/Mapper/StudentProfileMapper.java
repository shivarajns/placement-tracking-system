package com.Uniplace.backend.Mapper;

import com.Uniplace.backend.DTO.StudentProfileResponse;
import com.Uniplace.backend.DTO.UpdateStudentProfileRequest;
import com.Uniplace.backend.Model.StudentProfile;
import org.springframework.stereotype.Component;

@Component
public class StudentProfileMapper {

    public StudentProfileResponse toResponse(StudentProfile s){
        StudentProfileResponse r = new StudentProfileResponse();

        r.setUsername(s.getUsername());
        r.setEmail(s.getEmail());
        r.setPhone(s.getPhone());
        r.setLocation(s.getLocation());
        r.setInstitute(s.getInstitute());
        r.setCourse(s.getCourse());
        r.setBranch(s.getBranch());
        r.setDomain(s.getDomain());
        r.setSkills(s.getSkills());

        return r;
    }

    public void updateStudentProfile(StudentProfile s, UpdateStudentProfileRequest req){

        s.setUsername(req.getUsername());
        s.setPhone(req.getPhone());
        s.setLocation(req.getLocation());
        s.setInstitute(req.getInstitute());
        s.setCourse(req.getCourse());
        s.setBranch(req.getBranch());
        s.setDomain(req.getDomain());
        s.setSkills(req.getSkills());
    }
}
