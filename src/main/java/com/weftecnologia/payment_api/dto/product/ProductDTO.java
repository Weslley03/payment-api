package com.weftecnologia.payment_api.dto.product;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ProductDTO {
  private Integer id;
  private String name;
  private float price;
}
