package com.findbydema.domain.user.controller;

import com.findbydema.domain.user.controller.dto.request.GetRequest;
import com.findbydema.domain.user.controller.dto.request.LoginRequest;
import com.findbydema.domain.user.controller.dto.request.SignRequest;
import com.findbydema.domain.user.controller.dto.response.GetResponse;
import com.findbydema.domain.user.controller.dto.response.LoginResponse;
import com.findbydema.domain.user.service.GetService;
import com.findbydema.domain.user.service.LoginService;
import com.findbydema.domain.user.service.SignService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {
    private final LoginService loginService;
    private final SignService signService;
    private final GetService getService;

    @GetMapping("/")
    public GetResponse get(@RequestBody GetRequest getRequest) {
        return getService.get(getRequest);
    }


    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest loginRequest) {
        return loginService.login(loginRequest);
    }

    @PostMapping("/sign")
    public LoginResponse sign(@RequestBody SignRequest signRequest) {
        return signService.sign(signRequest);
    }
}
