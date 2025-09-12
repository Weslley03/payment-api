package com.weftecnologia.payment_api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.weftecnologia.payment_api.dto.payment.PaymentDTO;
import com.weftecnologia.payment_api.repository.PaymentRepository;
import com.weftecnologia.payment_api.util.JwtUtil;

@RestController
@RequestMapping("/payment")
public class PaymentController {

  private PaymentRepository paymentRepository;

  public PaymentController(PaymentRepository paymentRepository) {
    this.paymentRepository = paymentRepository;
  }

  @GetMapping("/{pixcode}")
  public PaymentDTO pixPayment(
      @RequestHeader(value = "Authorization", required = false) String authHeader,
      @PathVariable String pixcode) {
    JwtUtil.JwtValidationMiddleware(authHeader);
    return this.paymentRepository.makePixPayment(pixcode);
  }
}
