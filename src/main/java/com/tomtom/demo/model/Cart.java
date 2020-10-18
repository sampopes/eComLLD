package com.tomtom.demo.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

public class Cart {
   @Getter
   @Setter
   UUID customerId;

   @Getter
   @Setter
   UUID id;

   @Getter
   @Setter
   List<Product> productList;

   public double getValue(){
      return this.productList.stream().mapToDouble(value -> value.price ).sum();
   }
}
