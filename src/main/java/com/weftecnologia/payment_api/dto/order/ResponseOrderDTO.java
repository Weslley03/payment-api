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
  private String pixcode;
  private List<ProductDTO> products;

  public ResponseOrderDTO(
      Integer id,
      String userId,
      String payment_method,
      Float fullPrice,
      List<ProductDTO> products) {
    this.id = id;
    this.userId = userId;
    this.payment_method = payment_method;
    this.fullPrice = fullPrice;
    this.products = products;
  }
}
