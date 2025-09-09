package com.weftecnologia.payment_api.dto.order;

import java.util.List;

import com.weftecnologia.payment_api.dto.product.ProductDTO;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CreateOrderDTO {
  @NotBlank
  private String paymentMethod;

  @NotBlank
  private List<ProductDTO> products;
}
