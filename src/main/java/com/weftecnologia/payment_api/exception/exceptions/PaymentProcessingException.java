package com.weftecnologia.payment_api.exception.exceptions;

public class PaymentProcessingException extends RuntimeException {
  public PaymentProcessingException(String message) {
    super(message);
  }
}
