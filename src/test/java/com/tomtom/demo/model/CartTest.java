package com.tomtom.demo.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.util.AssertionErrors.assertEquals;

class CartTest {

   @Test
   void getValueForValidData() {
      Cart cart = new Cart();
      Product p = new Product();
      p.setPrice(12.5f);

      List<Product> list = new ArrayList<>();
      list.add(p);
      cart.setProductList(list);

      assertEquals("getValueForValidData" , 12.5, cart.getValue());
   }
}
