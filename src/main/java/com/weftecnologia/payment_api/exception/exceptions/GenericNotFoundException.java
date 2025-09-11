package com.weftecnologia.payment_api.exception.exceptions;

public class GenericNotFoundException extends RuntimeException {
  public GenericNotFoundException() {
    super("property not found");
  }

  public GenericNotFoundException(String classSearched) {
    super("could not be found in" + classSearched);
  }
}
