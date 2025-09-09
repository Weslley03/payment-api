package com.weftecnologia.payment_api.exception.exceptions;

public class JwtValidationException extends RuntimeException {
  public JwtValidationException(String errorReason) {
    super(errorReason);
  }
}
