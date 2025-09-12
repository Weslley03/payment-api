package com.weftecnologia.payment_api.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.weftecnologia.payment_api.dto.ResponseApiDTO;
import com.weftecnologia.payment_api.dto.product.PaginationRequestDTO;
import com.weftecnologia.payment_api.entity.Product;
import com.weftecnologia.payment_api.repository.ProductRepository;

@RestController
@RequestMapping("/product")
public class ProductController {

  private ProductRepository productRepository;

  public ProductController(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  @PostMapping("/get-all")
  public ResponseApiDTO<List<Product>> getAll(@RequestBody PaginationRequestDTO dto) {
    List<Product> products = this.productRepository.getAllProducts(dto);
    return new ResponseApiDTO<List<Product>>("products recovered.", HttpStatus.OK.value(), products);
  }
}
