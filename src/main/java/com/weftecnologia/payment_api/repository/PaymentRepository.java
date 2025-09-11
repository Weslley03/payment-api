package com.weftecnologia.payment_api.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.weftecnologia.payment_api.dto.payment.PaymentDTO;
import com.weftecnologia.payment_api.entity.Binding;
import com.weftecnologia.payment_api.entity.Order;
import com.weftecnologia.payment_api.enums.PaymentStatusEnum;
import com.weftecnologia.payment_api.exception.exceptions.GenericNotFoundException;
import com.weftecnologia.payment_api.exception.exceptions.PaymentProcessingException;
import com.weftecnologia.payment_api.util.JwtUtil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class PaymentRepository {

  @PersistenceContext
  EntityManager em;

  @Transactional
  public PaymentDTO makePixPayment(String pixCode) {
    Integer orderId = JwtUtil.getOrderId(pixCode);

    Order order = em.find(Order.class, orderId);
    Binding binding = this.checkOrderStatus(order);

    binding.setStatus(PaymentStatusEnum.paid);
    em.merge(binding);

    return new PaymentDTO(PaymentStatusEnum.paid, "payment made successfully.");
  }

  public PaymentDTO makeCreditCardPayment() {
    return new PaymentDTO(PaymentStatusEnum.paid, "payment made successfully.");
  }

  /* PRIVATE */

  private Binding checkOrderStatus(Order order) {
    if (order == null)
      throw new GenericNotFoundException("Order");

    TypedQuery<Binding> query = em.createQuery(
        "SELECT b FROM Binding b WHERE b.orderId = :orderId ",
        Binding.class);

    query.setParameter("orderId", order.getId());

    List<Binding> binding = query.getResultList();

    if (binding.isEmpty())
      throw new GenericNotFoundException("Binding");

    if (binding.get(0).getStatus().equals(PaymentStatusEnum.paid))
      throw new PaymentProcessingException("paid order");

    if (binding.get(0).getStatus().equals(PaymentStatusEnum.canceled))
      throw new PaymentProcessingException("canceled order");

    return binding.get(0);
  }
}
