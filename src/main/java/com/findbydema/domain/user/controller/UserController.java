package com.findbydema.domain.user.controller;

import com.findbydema.domain.user.controller.dto.request.GetUserRequest;
import com.findbydema.domain.user.controller.dto.request.LoginRequest;
import com.findbydema.domain.user.controller.dto.request.PatchUserRequest;
import com.findbydema.domain.user.controller.dto.request.SignRequest;
import com.findbydema.domain.user.controller.dto.response.GetResponse;
import com.findbydema.domain.user.controller.dto.response.LoginResponse;
import com.findbydema.domain.user.service.GetUserService;
import com.findbydema.domain.user.service.auth.LoginService;
import com.findbydema.domain.user.service.PatchUserService;
import com.findbydema.domain.user.service.auth.SignService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {
    private final LoginService loginService;
    private final SignService signService;
    private final GetUserService getUserService;
    private final PatchUserService patchUserService;

    // COMMON

    @GetMapping("/")
    public GetResponse get(@RequestBody GetUserRequest getUserRequest) {
        return getUserService.get(getUserRequest);
    }

    // AUTH

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest loginRequest) {
        return loginService.login(loginRequest);
    }

    @PostMapping("/sign")
    public LoginResponse sign(@RequestBody SignRequest signRequest) {
        return signService.sign(signRequest);
    }

    // INFO

    @PatchMapping("/patch")
    public void patch(@RequestBody PatchUserRequest patchUserRequest) {
        patchUserService.patch(patchUserRequest);
    }




}
