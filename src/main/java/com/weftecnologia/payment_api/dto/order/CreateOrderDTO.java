package com.weftecnologia.payment_api.dto.order;

import java.util.List;

import com.weftecnologia.payment_api.dto.product.ProductDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CreateOrderDTO {
  private String paymentMethod;
  private List<ProductDTO> products;
}
