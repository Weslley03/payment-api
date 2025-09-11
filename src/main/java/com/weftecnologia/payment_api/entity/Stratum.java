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
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "app_stratums")
public class Stratum {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @JoinColumn(name = "user_id", nullable = false)
  private String userId;

  @JoinColumn(name = "order_id", nullable = false)
  private Integer orderId;

  @Column(nullable = false)
  private float fullPrice;

  @Column(name = "created_at", updatable = false, insertable = false)
  private LocalDateTime createdAt;

  @Column(name = "updated_at")
  private LocalDateTime updatedAt;

  public Stratum(String userId, Integer orderId, float fullPrice) {
    this.userId = userId;
    this.orderId = orderId;
    this.fullPrice = fullPrice;
  }
}
