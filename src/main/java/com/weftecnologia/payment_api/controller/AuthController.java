package com.weftecnologia.payment_api.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.weftecnologia.payment_api.dto.user.AuthUserDTO;
import com.weftecnologia.payment_api.dto.user.ResponseAuthUserDTO;
import com.weftecnologia.payment_api.repository.AuthRepository;

@RestController
@RequestMapping("/auth")
public class AuthController {

  private final AuthRepository authRepository;

  public AuthController(AuthRepository authRepository) {
    this.authRepository = authRepository;
  }

  @PostMapping()
  public ResponseAuthUserDTO auth(@RequestBody AuthUserDTO dto) {
    return authRepository.auth(dto);
  }
}
