package com.weftecnologia.payment_api.dto.user;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ResponseAuthUserDTO {
  private boolean success;
  private String message;
  private String token;

  public ResponseAuthUserDTO(boolean success, String message) {
    this.success = success;
    this.message = message;
  }
}
