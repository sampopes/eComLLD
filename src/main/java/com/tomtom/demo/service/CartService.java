package com.tomtom.demo.service;

import com.tomtom.demo.model.Cart;
import com.tomtom.demo.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CartService {

   /**
    * update cart for a customer assumption: one customer can have only one cart
    * @param productList
    * @param customerId
    * @return
    */
   public UUID updateCart(List<Product> productList , UUID customerId){
      // Business login to update or create a cart if not present
      Cart cart = new Cart();
      cart.setCustomerId(customerId);
      UUID cartID = UUID.fromString(customerId.toString());
      cart.setProductList(productList); // fetch products from backend to maintain integrity
      cart.setId(cartID);

      return cart.getId();
   }

   /**
    * get fetch cart details from Repository(possibly an LRU cache
    *  lookup)
    *
    * @param id
    * @return
    */
   public Cart getCartById(UUID id){
      // fetch cart by id
      return new Cart();
   }

}
