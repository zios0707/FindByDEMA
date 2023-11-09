package com.findbydema.global.security.jwt;

import com.findbydema.domain.auth.entity.RefreshToken;
import com.findbydema.domain.auth.repository.RefreshTokenRepository;
import com.findbydema.domain.user.entity.User;
import com.findbydema.domain.user.exception.UserNotFoundException;
import com.findbydema.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@RequiredArgsConstructor
public class JwtAuthFilter extends OncePerRequestFilter {

    private final JwtProvider jwtProvider;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
        String accessToken = extractAccessTokens(request);
        String refreshToken = extractRefreshTokens(request);

        if(accessToken == null) {}
        else if (jwtProvider.isOk(accessToken)) {
            log.info("액세스 토큰 정상 확인.");
            Authentication authentication = jwtProvider.getAuthentication(accessToken);
            log.info(jwtProvider.getSID(accessToken));
            SecurityContextHolder.getContext().setAuthentication(authentication);
        } else {
            log.info("액세스 토큰 만료 및 오염 발견. 리프레쉬를 통한 액세스 재발급 실행");

            accessToken = jwtProvider.reProvideAccessToken(accessToken, refreshToken);

            if(accessToken != null) {
                Authentication authentication = jwtProvider.getAuthentication(accessToken);
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }

        }


        chain.doFilter(request, response);
    }

    private String extractAccessTokens(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        if(StringUtils.hasText(token) && token.startsWith("Bearer "))
            return token.substring("Bearer ".length());
        else
            return null;
    }

    private String extractRefreshTokens(HttpServletRequest request) {
        String token = request.getHeader("RefreshToken");
        if(StringUtils.hasText(token))
            return token;
        else
            return null;
    }

}
