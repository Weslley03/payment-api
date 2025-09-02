package com.weftecnologia.payment_api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.weftecnologia.payment_api.dto.ResponseApiDTO;
import com.weftecnologia.payment_api.dto.user.CreateUserDTO;
import com.weftecnologia.payment_api.dto.user.ResponseUserDTO;
import com.weftecnologia.payment_api.repository.UserRepository;

@RestController
@RequestMapping("/user")
public class UserController {

  private UserRepository userRepository;

  public UserController(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @PostMapping
  public ResponseApiDTO<ResponseUserDTO> create(@RequestBody CreateUserDTO dto) {
    ResponseUserDTO responseUserDTO = this.userRepository.create(dto);
    return new ResponseApiDTO<>("usuário cadastrado com sucesso.", HttpStatus.CREATED.value(), responseUserDTO);
  }
}
