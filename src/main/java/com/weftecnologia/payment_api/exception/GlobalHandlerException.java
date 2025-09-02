package com.weftecnologia.payment_api.exception;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.weftecnologia.payment_api.exception.exceptions.UserAlreadyExistsException;

@RestControllerAdvice
public class GlobalHandlerException {

  @ExceptionHandler(UserAlreadyExistsException.class)
  public ResponseEntity<?> handleUserAlreadyExistsException(UserAlreadyExistsException ex) {
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
        Map.of(
            "message", ex.getMessage(),
            "status", String.valueOf(HttpStatus.BAD_REQUEST.value())));
  }
}
