package com.weftecnologia.payment_api.dto.order;

import java.util.List;

import com.weftecnologia.payment_api.dto.product.ProductDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ResponseOrderDTO {
  private Integer id;
  private String userId;
  private String payment_method;
  private Float fullPrice;
  private List<ProductDTO> products;
}
