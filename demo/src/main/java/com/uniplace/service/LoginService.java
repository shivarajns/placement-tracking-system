package com.uniplace.service;

import com.uniplace.dto.LoginRequest;
import com.uniplace.dto.LoginResponse;

public interface LoginService {

     LoginResponse login(LoginRequest request);
}
