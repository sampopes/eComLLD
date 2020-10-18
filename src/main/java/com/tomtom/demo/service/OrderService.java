package com.tomtom.demo.service;

import com.tomtom.demo.constants.OrderStatuses;
import com.tomtom.demo.exception.OrderProcessingException;
import com.tomtom.demo.exception.PaymentFailedException;
import com.tomtom.demo.model.Cart;
import com.tomtom.demo.model.Order;
import com.tomtom.demo.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class OrderService {

   @Autowired
   private CartService cartService;

   /**
    * Implementation will ensure that all products of the cart
    * are available
    *
    * @param productList
    * @return
    */
   private String validateOrder(List<Product> productList){
      // In ideal case this method would return complete
      //

      return OrderStatuses.AVAILABILITY_VALIDATION_PASS;
   }


   /**
    * Create an order after validation and payment process done
    * @param cartId
    * @return
    */
   public Order createOrder(UUID cartId){
      Cart cart = this.cartService.getCartById(cartId);

      if(this.validateOrder(cart.getProductList()) == OrderStatuses.AVAILABILITY_VALIDATION_PASS ){
         throw new OrderProcessingException("Items from cart not available" );
      }

      Order order = new Order();
      order.setCartId(cartId);
      order.setCustomerId(cart.getCustomerId());
      order.setCartValue(cart.getValue());

      String paymentStatus = this.processPayment();
      if( paymentStatus == OrderStatuses.PAYMENT_FAILED){
         throw new PaymentFailedException("Payment Failed from cart not available" );
      }

      return order;
   }

   private String processPayment () {
      // Should do payment confirmation by calling third party api
      //
      return OrderStatuses.PAYMENT_SUCCESS;
   }

}
