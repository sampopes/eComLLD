package com.tomtom.demo.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.UUID;

import static java.util.UUID.randomUUID;


public class Product implements Serializable {
   @Getter
   private UUID productId;

   @Getter
   @Setter
   private String name;

   @Getter
   @Setter
   private String productType;

   @Getter
   @Setter
   private String productSubType;

   @Getter
   @Setter
   float price;

   @Getter
   @Setter
   private int sellerId;

   @Getter
   @Setter
   private boolean isAvailable;

   public Product() {
      this.productId = randomUUID();
   }

}
