package com.weftecnologia.payment_api.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "app_orders")
public class Order {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @JoinColumn(name = "user_id", nullable = false)
  private String userId;

  @Column(nullable = false)
  private float fullPrice;

  @Column(nullable = false)
  private String paymentMethod;

  @Column(name = "created_at", updatable = false, insertable = false)
  private LocalDateTime createdAt;

  @Column(name = "updated_at")
  private LocalDateTime updatedAt;

  public Order(String userId, float fullPrice, String paymentMethod) {
    this.userId = userId;
    this.fullPrice = fullPrice;
    this.paymentMethod = paymentMethod;
  }
}
