package com.findbydema.global.security.jwt;

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
        String token = extractToken(request);

        if (token != null && jwtProvider.validateToken(token)) {
            Authentication authentication = jwtProvider.getAuthentication(token);

            SecurityContextHolder.getContext().setAuthentication(authentication);
        }else {
            log.info("토큰이 유효하지 않습니다.");
        }

        chain.doFilter(request, response);

    }

    private String extractToken(HttpServletRequest request) {
        String token = request.getHeader("Authoriztion");
        if(StringUtils.hasText(token) && token.startsWith("Bearer "))
            return token.substring("Bearer ".length());
        else
            return null;
    }

}
