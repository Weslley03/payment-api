package com.weftecnologia.payment_api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ResponseApiDTO<T> {

  private String message;
  private int status;
  private T response;

  public ResponseApiDTO(String message, int status) {
    this.message = message;
    this.status = status;
  }
}
