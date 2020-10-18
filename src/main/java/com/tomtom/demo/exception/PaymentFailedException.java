package com.tomtom.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class PaymentFailedException extends RuntimeException {
   public PaymentFailedException(String exception) {
   }
}
