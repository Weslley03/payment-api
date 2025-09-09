package com.weftecnologia.payment_api.dto.binding;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ResponseBindingDTO {
  private String id;
  private String orderId;
  private String status;
}
