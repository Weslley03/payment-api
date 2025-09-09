package com.weftecnologia.payment_api.dto.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AuthUserDTO {

  @NotBlank
  @Email
  private String email;

  @Size(min = 8)
  private String password;
}
