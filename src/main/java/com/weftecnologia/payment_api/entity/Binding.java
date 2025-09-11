package com.weftecnologia.payment_api.entity;

import java.time.LocalDateTime;

import com.weftecnologia.payment_api.enums.PaymentStatusEnum;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
@Table(name = "app_bindings")
public class Binding {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @JoinColumn(name = "order_id", nullable = false)
  private Integer orderId;

  @Column(nullable = false)
  @Enumerated(EnumType.STRING)
  private PaymentStatusEnum status;

  @Column(name = "created_at", updatable = false, insertable = false)
  private LocalDateTime createdAt;

  @Column(name = "updated_at")
  private LocalDateTime updatedAt;

  public Binding(Integer orderId, PaymentStatusEnum status) {
    this.orderId = orderId;
    this.status = status;
  }
}
