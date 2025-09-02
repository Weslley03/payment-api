package com.weftecnologia.payment_api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.weftecnologia.payment_api.dto.ResponseApiDTO;
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
  public ResponseApiDTO<ResponseAuthUserDTO> auth(@RequestBody AuthUserDTO dto) {
    ResponseAuthUserDTO responseAuthUserDTO = authRepository.auth(dto);
    if (!responseAuthUserDTO.isSuccess()) {
      return new ResponseApiDTO<ResponseAuthUserDTO>(
          "falha na autenticação.",
          HttpStatus.BAD_REQUEST.value(),
          responseAuthUserDTO);
    }
    return new ResponseApiDTO<ResponseAuthUserDTO>("logged user.", HttpStatus.OK.value(), responseAuthUserDTO);
  }
}
