package com.findbydema.domain.user.service.auth;

import com.findbydema.domain.user.controller.dto.request.LoginRequest;
import com.findbydema.domain.user.controller.dto.request.SignRequest;
import com.findbydema.domain.user.controller.dto.response.LoginResponse;
import com.findbydema.domain.user.entity.User;
import com.findbydema.domain.user.exception.auth.AlreadyExistEmailException;
import com.findbydema.domain.user.exception.auth.AlreadyExistSIDException;
import com.findbydema.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SignService {
    private final UserRepository repository;
    private final LoginService loginService;

    public LoginResponse sign(SignRequest request) {
    // 공백 정보나 이상한 정보가 담길 우려는 없음 (프론트에서 반응형으로 유효처리를 해줄 것이라서)

        if(repository.findByStudentId(request.getStudentID()).isPresent()) {
            throw AlreadyExistEmailException.EMAIL_EXCEPTION;
        }

        if(repository.findByEmail(request.getStudentID()).isPresent()) {
            throw AlreadyExistSIDException.SID_EXCEPTION;
        }

        repository.save(new User(
                request.getNickname(),
                request.getStudentID(),
                request.getEmail(),
                request.getPassword(),
                request.getImg()
        ));

        return loginService.login(LoginRequest.builder() // 정보가 유효하니 바로 로그인으로 진행
                .StudentID(request.getStudentID())
                .password(request.getPassword())
                .build());
    }
}