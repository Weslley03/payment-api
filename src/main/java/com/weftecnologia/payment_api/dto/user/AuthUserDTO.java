package com.weftecnologia.payment_api.dto.user;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AuthUserDTO {
  private String email;
  private String name;
  private String password;
}
