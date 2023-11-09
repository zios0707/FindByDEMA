package com.findbydema.domain.auth.service;

import com.findbydema.domain.auth.entity.RefreshToken;
import com.findbydema.domain.auth.repository.RefreshTokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class SaveTokenService {

    private final RefreshTokenRepository tokenRepository;

    public void execute(String SID, String refreshToken, String accessToken) {
        tokenRepository.save(RefreshToken.builder()
                .id(SID)
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .build());
    }

}
