package com.weftecnologia.payment_api.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.weftecnologia.payment_api.dto.order.CreateOrderDTO;
import com.weftecnologia.payment_api.dto.order.ResponseOrderDTO;
import com.weftecnologia.payment_api.dto.product.ProductDTO;
import com.weftecnologia.payment_api.entity.Binding;
import com.weftecnologia.payment_api.entity.Order;
import com.weftecnologia.payment_api.entity.OrderHaveProduct;
import com.weftecnologia.payment_api.entity.Stratum;
import com.weftecnologia.payment_api.enums.PaymentStatusEnum;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
public class OrderRepository {

  @PersistenceContext
  private EntityManager em;

  @Transactional
  public ResponseOrderDTO create(CreateOrderDTO dto, String userId) {
    Float fullPrice = dto.getProducts().stream()
        .map(ProductDTO::getPrice)
        .reduce(0f, Float::sum);

    Order order = new Order(userId, fullPrice, dto.getPaymentMethod());
    em.persist(order);

    this.createOrdersHaveProducts(order.getId(), dto.getProducts());

    em.persist(new Stratum(userId, order.getId(), fullPrice));
    em.persist(new Binding(order.getId(), PaymentStatusEnum.pending));

    return new ResponseOrderDTO(order.getId(), userId, dto.getPaymentMethod(), fullPrice, dto.getProducts());
  }

  private void createOrdersHaveProducts(Integer orderId, List<ProductDTO> products) {
    List<Integer> productIds = products.stream()
        .map(ProductDTO::getId)
        .toList();

    List<OrderHaveProduct> relations = productIds.stream()
        .map(productId -> new OrderHaveProduct(orderId, productId))
        .toList();

    relations.forEach(em::persist);
  }
}