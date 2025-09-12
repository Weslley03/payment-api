package com.weftecnologia.payment_api.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.weftecnologia.payment_api.exception.exceptions.GenericNotFoundException;
import com.weftecnologia.payment_api.exception.exceptions.JwtValidationException;
import com.weftecnologia.payment_api.exception.exceptions.PaymentProcessingException;
import com.weftecnologia.payment_api.exception.exceptions.UserAlreadyExistsException;

@RestControllerAdvice
public class GlobalHandlerException {

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<?> handleValidatonsErros(MethodArgumentNotValidException ex) {
    Map<String, String> errors = new HashMap<>();

    ex.getBindingResult().getFieldErrors().forEach(err -> {
      errors.put(err.getField(), err.getDefaultMessage());
    });

    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
        Map.of(
            "message", "body request validation error.",
            "status", String.valueOf(HttpStatus.BAD_REQUEST.value()),
            "errors", errors));
  }

  @ExceptionHandler(UserAlreadyExistsException.class)
  public ResponseEntity<?> handleUserAlreadyExistsException(UserAlreadyExistsException ex) {
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
        Map.of(
            "message", ex.getMessage(),
            "status", String.valueOf(HttpStatus.BAD_REQUEST.value())));
  }

  @ExceptionHandler(JwtValidationException.class)
  public ResponseEntity<?> handleJwtValidationException(JwtValidationException ex) {
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
        Map.of(
            "message", ex.getMessage(),
            "status", String.valueOf(HttpStatus.BAD_REQUEST.value())));
  }

  @ExceptionHandler(PaymentProcessingException.class)
  public ResponseEntity<?> handlePaymentProcessingException(PaymentProcessingException ex) {
    return ResponseEntity.status(HttpStatus.BAD_REQUEST.value()).body(
        Map.of(
            "message", ex.getMessage(),
            "status", String.valueOf(HttpStatus.BAD_REQUEST.value())));
  }

  @ExceptionHandler(GenericNotFoundException.class)
  public ResponseEntity<?> handleGenericNotFoundException(GenericNotFoundException ex) {
    return ResponseEntity.status(HttpStatus.NOT_FOUND.value()).body(
        Map.of(
            "message", ex.getMessage(),
            "status", String.valueOf(HttpStatus.NOT_FOUND.value())));
  }

  @ExceptionHandler(HttpMessageNotReadableException.class)
  public ResponseEntity<?> handleHttpMessageNotReadable(HttpMessageNotReadableException ex) {
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
        Map.of(
            "message", "Invalid or missing request body.",
            "status", String.valueOf(HttpStatus.BAD_REQUEST.value())));
  }
}
