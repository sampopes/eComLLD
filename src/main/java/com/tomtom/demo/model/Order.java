package com.tomtom.demo.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.UUID;


public class Order implements Serializable {
   @Getter
   UUID orderId;

   @Getter
   @Setter
   UUID customerId;

   @Getter
   @Setter
   UUID cartId;

   @Getter
   @Setter
   double cartValue;

   @Getter
   @Setter
   String paymentStatus;

   /**
    * every order creation is assigned with new ID
    */
   public Order() {
      this.orderId = UUID.randomUUID();
   }
}
