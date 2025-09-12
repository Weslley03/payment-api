package com.weftecnologia.payment_api.dto.product;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PaginationRequestDTO {
  private int page;
  private int size;
}
