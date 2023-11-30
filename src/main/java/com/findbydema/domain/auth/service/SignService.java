package com.findbydema.domain.auth.service;

import com.findbydema.domain.auth.exception.AlreadyExistEmailException;
import com.findbydema.domain.auth.exception.AlreadyExistSIDException;
import com.findbydema.domain.user.controller.dto.request.LoginRequest;
import com.findbydema.domain.user.controller.dto.request.SignRequest;
import com.findbydema.domain.user.controller.dto.response.LoginResponse;
import com.findbydema.domain.user.entity.User;
import com.findbydema.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
@Transactional
@RequiredArgsConstructor
public class SignService {
    private final UserRepository repository;
    private final LoginService loginService;

    public LoginResponse sign(SignRequest request) {
    // 공백 정보나 이상한 정보가 담길 우려는 없음 (프론트에서 반응형으로 유효처리를 해줄 것이라서)

        if(repository.findBySid(request.getSid()).isPresent()) {
            throw AlreadyExistEmailException.EMAIL_EXCEPTION;
        }

        if(repository.findByEmail(request.getSid()).isPresent()) {
            throw AlreadyExistSIDException.SID_EXCEPTION;
        }

        repository.save(new User(
                request.getNickname(),
                request.getSid(),
                request.getEmail(),
                request.getPassword(),
                request.getImg(),
                new Date()
        ));

        return loginService.login(LoginRequest.builder() // 정보가 유효하니 바로 로그인으로 진행
                .sid(request.getSid())
                .password(request.getPassword())
                .build());
    }
}