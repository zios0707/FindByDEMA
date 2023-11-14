package com.findbydema.domain.auth.service;


import com.findbydema.domain.auth.entity.RefreshToken;
import com.findbydema.domain.auth.exception.TokenNotFoundException;
import com.findbydema.domain.auth.repository.RefreshTokenRepository;
import com.findbydema.domain.user.entity.User;
import com.findbydema.domain.user.repository.UserRepository;
import com.findbydema.domain.user.service.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@RequiredArgsConstructor
@Service
public class DeleteAccountService {

    private final UserRepository userRepository;
    private final RefreshTokenRepository refreshTokenRepository;
    private final UserFacade userFacade;

    public void execute(String accessToken) {
        User user = userFacade.getInfo();

        userRepository.delete(user);

        RefreshToken refreshToken = refreshTokenRepository.findByAccessToken(accessToken)
                .orElseThrow(() -> TokenNotFoundException.EXCEPTION);

        refreshTokenRepository.delete(refreshToken);
    }


}
