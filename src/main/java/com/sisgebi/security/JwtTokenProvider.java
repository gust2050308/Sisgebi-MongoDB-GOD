package com.sisgebi.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Base64;
import java.util.Date;

@Component
public class JwtTokenProvider {
    private final String SECRET_KEY = "z2/xmfwvIfoCpwhf3oIigofeYFuxL8F3g4Vy9jIOCTR1iQ+oUbVnqu8aE2WYFmfqt4x5n97yV1firAmOlQ32uQ==";
    private final long EXPIRATION_TIME = 1000 * 60 * 60; // 1 hora

    public String generateToken(String email, String role, String id, String nombres, String apellidos) { // Ahora recibe email, rol y id
        return Jwts.builder()
                .setSubject(email) // Guarda el correo en el token
                .claim("role", role) // Agrega el rol como un claim adicional
                .claim("id", id) // Agrega el ID del usuario como un claim adicional
                .claim("nombres", nombres)
                .claim("apellidos", apellidos)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS512, Base64.getDecoder().decode(SECRET_KEY))
                .compact();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(Base64.getDecoder().decode(SECRET_KEY))
                    .build()
                    .parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Claims getClaimsFromToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(Base64.getDecoder().decode(SECRET_KEY))
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}
