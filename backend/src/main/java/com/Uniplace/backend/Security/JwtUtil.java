package com.Uniplace.backend.Security;


import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.security.Key;
import java.util.Date;

@Component
public class JwtUtil {

    private final String SECRET_KEY =
            "uniplace_secret_key_uniplace_secret_key_123";

    private final long EXPIRATION_TIME = 60*60*1000;

    private Key getSigninKey(){
        return Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
    }

    public String generateKey (String email){
        return Jwts.builder()
                .setSubject(email)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(getSigninKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    //get email from the token
    public String extractEmail(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSigninKey())
                .build()
                .parseClaimsJwt(token)
                .getBody()
                .getSubject();
    }

    public boolean vaildateToken(String token) {
        try {
            extractEmail(token);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }
}
