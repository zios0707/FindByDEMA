package com.findbydema.domain.auth.controller;

import com.findbydema.domain.auth.service.DeleteAccountService;
import com.findbydema.domain.auth.service.LoginService;
import com.findbydema.domain.auth.service.SignService;
import com.findbydema.domain.user.controller.dto.request.LoginRequest;
import com.findbydema.domain.user.controller.dto.request.SignRequest;
import com.findbydema.domain.user.controller.dto.response.LoginResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class AuthController {
    private final LoginService loginService;
    private final SignService signService;
    private final DeleteAccountService deleteAccountService;

    // AUTH

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest loginRequest) {
        return loginService.login(loginRequest);
    }

    @PostMapping("/sign")
    public LoginResponse sign(@RequestBody SignRequest signRequest) {
        return signService.sign(signRequest);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestHeader("authorization") String accessToken) {
        deleteAccountService.execute(accessToken);
    }


}
