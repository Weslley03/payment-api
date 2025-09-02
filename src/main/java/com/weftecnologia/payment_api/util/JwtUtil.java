package com.weftecnologia.payment_api.util;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

import com.weftecnologia.payment_api.config.EnvVariables;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

public class JwtUtil {

  private static final Key key = Keys.hmacShaKeyFor(EnvVariables.getJWTSecretKey().getBytes(StandardCharsets.UTF_8));

  public static String generateToken(String email) {
    long expirationTime = 1000 * 60 * 60;
    return Jwts.builder()
        .setSubject(email)
        .setIssuedAt(new Date())
        .setExpiration(new Date(System.currentTimeMillis() + expirationTime))
        .signWith(key)
        .compact();
  }

  public static boolean validateToken(String token) {
    try {
      Jwts.parserBuilder()
          .setSigningKey(key)
          .build()
          .parseClaimsJws(token);
      return true;
    } catch (Exception e) {
      return false;
    }
  }
}
