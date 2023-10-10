package com.findbydema.global.security.jwt;

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

import java.util.Date;

@Slf4j
@Component
@RequiredArgsConstructor
public class JwtProvider {

    @Value("${jwt.secret}")
    private String secretKey;

    private final UserDetailsService userDetailsService;

    public String createAccessToken(String SID) {
        return createToken(SID, "Access", 24 * 60L); // 1시간 // 테스트 환경에선 24시간
    }

    public String createRefreshToken(String SID) {
        return createToken(SID, "Refresh", 14 * 24 * 60L); // 14일
    }

    public String createToken(String SID, String type, Long expireTimeMs) {
        if (SID == null) {
            throw InvalidDataException.EXCEPTION;
        }

        try {
            return Jwts.builder()
                    .claim("type", type)
                    .setIssuedAt(new Date(System.currentTimeMillis()))
                    .setSubject(SID)
                    .setExpiration(new Date(System.currentTimeMillis() + expireTimeMs * 1000 * 60L))
                    .signWith(SignatureAlgorithm.HS256, secretKey)
                    .compact();
        } catch (JwtException e) {
            throw JwtCompactFailException.EXCEPTION;
        }
    }

    public Boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
            return Boolean.TRUE;
        } catch (JwtException e) {
            return Boolean.FALSE;
        }
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

}