package com.weftecnologia.payment_api.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class User {

  private String id;
  private String name;
  private String email;
  private String password;
}
