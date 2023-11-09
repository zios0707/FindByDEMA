package com.findbydema.global.security.jwt;

import com.findbydema.domain.auth.entity.RefreshToken;
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
import java.util.Optional;

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

    // 리프레시 - 액세스 재발급 구간

    public String reProvideAccessToken(String accessToken, String refreshToken) {
        Optional<RefreshToken> OfoundTokenInfo = tokenRepository.findByAccessToken(accessToken);


        if(OfoundTokenInfo.isEmpty()) return null;
        RefreshToken foundTokenInfo = OfoundTokenInfo.get();
        String foundRefresh = foundTokenInfo.getRefreshToken();
        if (!isOk(foundRefresh)){
            log.info("액세스, 리프레시 둘 다 개판");
            return null;
        }
        Optional<User> Ouser = userRepository.findBySid(foundTokenInfo.getId());

        if(!Ouser.isPresent()) {
            log.info("유저가 없다요 맨");
            return null;
        }
        User user = Ouser.get();
        accessToken = createAccessToken(user.getSid());
        tokenRepository.save(new RefreshToken(user.getSid(), refreshToken, accessToken));

        log.info("정상 작동");
        return accessToken;
    }

}