package com.weftecnologia.payment_api.dto.payment;

import com.weftecnologia.payment_api.enums.PaymentStatusEnum;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PaymentDTO {
  private PaymentStatusEnum status;
  private String message;
}
