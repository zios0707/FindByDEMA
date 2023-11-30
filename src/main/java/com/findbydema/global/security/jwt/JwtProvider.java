package com.findbydema.global.security.jwt;

import com.findbydema.domain.auth.entity.RefreshToken;
import com.findbydema.domain.auth.exception.MismatchedTokenException;
import com.findbydema.domain.auth.exception.TokenNotFoundException;
import com.findbydema.domain.auth.repository.RefreshTokenRepository;
import com.findbydema.domain.user.entity.User;
import com.findbydema.domain.user.exception.UserNotFoundException;
import com.findbydema.domain.user.repository.UserRepository;
import com.findbydema.global.security.jwt.exception.InvalidDataException;
import com.findbydema.global.security.jwt.exception.JwtCompactFailException;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Slf4j
@Component
@Transactional
@RequiredArgsConstructor
public class JwtProvider {

    @Value("${jwt.secret}")
    private String secretKey;

    private final UserDetailsService userDetailsService;
    private final RefreshTokenRepository tokenRepository;
    private final UserRepository userRepository;

    public String createAccessToken(String SID) {
        return createToken(SID, "Access", 24 * 60L); // 1시간 // 테스트 환경에선 1일로
    }

    public String createRefreshToken(String SID) {
        return createToken(SID, "Refresh",  14 * 24 * 60L); // 14일
    }

    public String createToken(String SID, String type, Long expireTimeMs) {
        if (SID == null) {
            throw InvalidDataException.EXCEPTION;
        }

        try {
            return Jwts.builder()
                    .claim("type", type)
                    .setSubject(SID)
                    .signWith(SignatureAlgorithm.HS256, secretKey)
                    .setIssuedAt(new Date(System.currentTimeMillis()))
                    .setExpiration(new Date(System.currentTimeMillis() + expireTimeMs * 60 * 1000L))
                    .compact();
        } catch (JwtException e) {
            throw JwtCompactFailException.EXCEPTION;
        }
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
            return true;
        } catch (JwtException e) {
            return false;
        }
    }

    public boolean isExpired(String token) {
        try {
            return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().getExpiration().before(new Date());
        }catch (JwtException e) {
            return true;
        }
    }

    public boolean isOk(String token) {
        return validateToken(token) && !isExpired(token);
    }

    public Authentication getAuthentication(String token) {
        try {
            UserDetails userDetails = userDetailsService.loadUserByUsername(this.getSID(token));
            return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
        }catch (JwtException e) {
            return null;
        }
    }

    public String getSID(String token) {
        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().getSubject();
    }

    // 액세스 재발급 구간
    @Transactional
    public String reProvideAccessToken(String refreshToken) {
        RefreshToken foundToken = tokenRepository.findByRefreshToken(refreshToken)
                .orElseThrow(() -> TokenNotFoundException.EXCEPTION);

        if(!refreshToken.equals(foundToken.getRefreshToken())) throw MismatchedTokenException.EXCEPTION;

        User user = userRepository.findBySid(foundToken.getId())
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);

        String accessToken = createAccessToken(user.getSid());
        foundToken.setAccessToken(accessToken);

        tokenRepository.save(foundToken);
        return accessToken;
    }

    @Transactional
    public void reProvideRefreshToken(String accessToken) {
        RefreshToken foundToken = tokenRepository.findByAccessToken(accessToken)
                .orElseThrow(() -> TokenNotFoundException.EXCEPTION);

        User user = userRepository.findBySid(foundToken.getId())
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);

        String refreshToken = createRefreshToken(user.getSid());
        foundToken.setRefreshToken(refreshToken);

        tokenRepository.save(foundToken);
    }

}