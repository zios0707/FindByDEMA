package com.findbydema.domain.user.service;

import com.findbydema.domain.user.controller.dto.response.UserResponse;
import com.findbydema.domain.user.entity.User;
import com.findbydema.domain.user.exception.UserNotFoundException;
import com.findbydema.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Date;

@RequiredArgsConstructor
@Service
public class UserFacade {
    private final UserRepository userRepository;

    public User getInfo() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        return userRepository.findByEmail(email)
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);
    }

    public User findBySid(String SID) {
        return userRepository.findBySid(SID)
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);
    }

    public UserResponse sidToResponse(String sid) {
        User user = findBySid(sid);
        return UserResponse.builder()
                .img(user.getImg())
                .sid(user.getSid())
                .makeDate(new Date())
                .nickname(user.getNickname())
                .build();
    }


}
