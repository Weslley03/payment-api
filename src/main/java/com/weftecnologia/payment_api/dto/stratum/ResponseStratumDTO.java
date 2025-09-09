package com.weftecnologia.payment_api.dto.stratum;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ResponseStratumDTO {
  private String id;
  private String userId;
  private String orderId;
  private float fullPrice;
  private String status;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;
}
