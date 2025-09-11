package com.weftecnologia.payment_api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.weftecnologia.payment_api.dto.ResponseApiDTO;
import com.weftecnologia.payment_api.dto.order.CreateOrderDTO;
import com.weftecnologia.payment_api.dto.order.ResponseOrderDTO;
import com.weftecnologia.payment_api.repository.OrderRepository;
import com.weftecnologia.payment_api.util.JwtUtil;

@RestController
@RequestMapping("/order")
public class OrderController {

  private OrderRepository orderRepository;

  public OrderController(OrderRepository orderRepository) {
    this.orderRepository = orderRepository;
  }

  @PostMapping
  public ResponseApiDTO<ResponseOrderDTO> create(
      @RequestHeader(value = "Authorization", required = false) String authHeader,
      @RequestBody CreateOrderDTO dto) {
    String userId = JwtUtil.JwtValidationMiddleware(authHeader);
    ResponseOrderDTO responseOrderDTO = this.orderRepository.create(dto, userId);
    return new ResponseApiDTO<ResponseOrderDTO>(
        "usuário cadastrado com sucesso.",
        HttpStatus.CREATED.value(),
        responseOrderDTO);
  }
}
