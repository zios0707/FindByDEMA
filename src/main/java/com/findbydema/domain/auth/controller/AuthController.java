package com.findbydema.domain.auth.controller;

import com.findbydema.domain.auth.service.LoginService;
import com.findbydema.domain.auth.service.SignService;
import com.findbydema.domain.user.controller.dto.request.LoginRequest;
import com.findbydema.domain.user.controller.dto.request.SignRequest;
import com.findbydema.domain.user.controller.dto.response.LoginResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class AuthController {
    private final LoginService loginService;
    private final SignService signService;

    // AUTH

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest loginRequest) {
        return loginService.login(loginRequest);
    }

    @PostMapping("/sign")
    public LoginResponse sign(@RequestBody SignRequest signRequest) {
        return signService.sign(signRequest);
    }


}
