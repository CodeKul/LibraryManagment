package com.codekul.LibraryManagement.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Base64;
import java.util.Date;
import java.util.Map;

@Component
public class JwtUtil {
//
//    @Value("${jwt.secret}")
//    private String secretKey;

    @Value("${jwt.expiration}")
    private long expiration;

    public String generateToken(Map<String, Object> claims) {
        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(SignatureAlgorithm.HS256, "codekul")
                .compact();
    }


    public String extractUsername(String token) {
        Claims claims = getClaimsFromToken(token);
        return (String) claims.get("username");
    }

    public String extractRole(String token) {
        Claims claims = getClaimsFromToken(token);
        System.out.println("extract role===>"+(String) claims.get("role"));
        return (String) claims.get("role");
    }

    private Claims getClaimsFromToken(String token) {
        Claims claims;
        try {
            claims = Jwts.parser()
                    .setSigningKey("codekul")
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e) {
            claims = null;
        }
        System.out.println("claims===================>>"+claims);

        return claims;
    }

    public boolean validateToken(String token, String username) {
        return (username.equals(extractUsername(token)));
    }
}
