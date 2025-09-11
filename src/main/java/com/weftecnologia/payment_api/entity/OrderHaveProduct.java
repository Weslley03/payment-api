package com.weftecnologia.payment_api.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "app_order_have_products")
public class OrderHaveProduct {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @JoinColumn(name = "order_id", nullable = false)
  private Integer orderId;

  @JoinColumn(name = "product_id", nullable = false)
  private Integer productId;

  public OrderHaveProduct(Integer orderId, Integer productId) {
    this.orderId = orderId;
    this.productId = productId;
  }
}
