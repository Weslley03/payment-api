package com.weftecnologia.payment_api.exception.exceptions;

public class UserAlreadyExistsException extends RuntimeException {
  public UserAlreadyExistsException(String email) {
    super("user with email " + email + " already exists.");
  }
}
