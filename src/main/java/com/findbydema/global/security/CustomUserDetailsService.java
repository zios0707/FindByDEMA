package com.findbydema.global.security;

import com.findbydema.domain.user.exception.UserNotFoundException;
import com.findbydema.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        return userRepository.findByStudentId(username)
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);
    }

}
