package com.weftecnologia.payment_api.util;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

import com.weftecnologia.payment_api.config.EnvVariables;
import com.weftecnologia.payment_api.exception.exceptions.JwtValidationException;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

public class JwtUtil {

  private static final Key key = Keys.hmacShaKeyFor(EnvVariables.getJWTSecretKey().getBytes(StandardCharsets.UTF_8));

  public static String generateToken(String userId) {
    long expirationTime = 1000 * 60 * 60;
    return Jwts.builder()
        .setSubject(userId)
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

  public static String getUserIdFromToken(String token) {
    return Jwts.parserBuilder()
        .setSigningKey(key)
        .build()
        .parseClaimsJws(token)
        .getBody()
        .getSubject();
  }

  public static String JwtValidationMiddleware(String authHeader) {
    if (authHeader == null || !authHeader.startsWith("Bearer ")) {
      throw new JwtValidationException("Invalid Authorization header");
    }

    String token = authHeader.substring(7);

    if (!JwtUtil.validateToken(token)) {
      throw new JwtValidationException("Invalid JWT token");
    }

    return getUserIdFromToken(token);
  }
}
