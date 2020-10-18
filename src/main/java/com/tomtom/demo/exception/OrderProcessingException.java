package com.tomtom.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class OrderProcessingException extends RuntimeException {

   public OrderProcessingException(String message){
      super(message);
   }
}
