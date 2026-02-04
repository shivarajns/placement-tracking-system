package com.uniplace.service.imp;


import com.uniplace.dto.RegisterRequest;
import com.uniplace.model.AdminStudent;
import com.uniplace.model.StudentProfile;
import com.uniplace.model.User;
import com.uniplace.repository.AdminStudentRepository;
import com.uniplace.repository.StudentProfileRepository;
import com.uniplace.repository.UserRepository;
import com.uniplace.service.RegistrationService;
import jakarta.transaction.Transactional;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegistrationServiceImpl implements RegistrationService {

    private final AdminStudentRepository adminStudentRepository;
    private final StudentProfileRepository studentProfileRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    public RegistrationServiceImpl(AdminStudentRepository adminStudentRepository, StudentProfileRepository studentProfileRepository, UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.adminStudentRepository = adminStudentRepository;
        this.studentProfileRepository = studentProfileRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    @Transactional
    public void registerStudent(RegisterRequest request) {
        AdminStudent adminStudent = AdminStudentRepository.findByEmailAndUsnAndInstituteId(
                request.getEmail(),
                request.getUsn(),
                request.getInstituteId()
        ).orElseThrow(() ->
                new RuntimeException("Student not eligible for registration"));

        if(adminStudent.getIsRegistered()){
            throw new RuntimeException("Student already Registered");
        }

        if(userRepository.existsByEmail(request.getEmail())){
            throw new RuntimeException("Email is already in Use");
        }

        User user = new User();
        user.setEmail(request.getEmail());
        user.setUsn(request.getUsn());
        user.setInstitute_id(request.getInstituteId());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        userRepository.save(user);

        StudentProfile profile = new StudentProfile();
        profile.setUser(user);
        profile.setName(request.getName());
        profile.setUsn(request.getUsn());
        profile.setInstituteId(request.getInstituteId());
        profile.setInstituteName(adminStudent.getInstituteName());
        profile.setBranch(adminStudent.getBranch());
        studentProfileRepository.save(profile);

        adminStudent.setIsRegistered(true);
        adminStudentRepository.save(adminStudent);
    }

}
