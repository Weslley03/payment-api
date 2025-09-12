package com.weftecnologia.payment_api.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.weftecnologia.payment_api.dto.product.PaginationRequestDTO;
import com.weftecnologia.payment_api.entity.Product;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class ProductRepository {

  @PersistenceContext
  EntityManager em;

  public List<Product> getAllProducts(PaginationRequestDTO req) {
    int page = req.getPage();
    int size = req.getSize();

    return em.createQuery(
        "SELECT p FROM Product p", Product.class)
        .setFirstResult(page * size)
        .setMaxResults(size)
        .getResultList();
  }
}
