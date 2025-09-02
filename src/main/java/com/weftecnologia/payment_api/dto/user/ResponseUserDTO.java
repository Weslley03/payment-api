package com.weftecnologia.payment_api.dto.user;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ResponseUserDTO {
  private String id;
  private String name;
  private String email;
}
