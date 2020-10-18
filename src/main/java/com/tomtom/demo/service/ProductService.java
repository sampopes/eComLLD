package com.tomtom.demo.service;

import com.tomtom.demo.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

   /**
    * Returns products by product types
    * @param type
    * @return
    */
   public List<Product> getProductsByType(String type){
      List<Product> list = new ArrayList<Product>();
      // Business logic to fetch products

      return list;
   }

   /**
    * Adds products to repository
    * @param products
    */
   public String addProducts(List<Product> products , int sellerId){
      // Business logic to save products

      return "success";
   }

   /**
    * Marks product as sold or available
    *
    * @param products
    * @param isSold
    */
   public void markAvailability(List<Product> products , boolean isSold){
      products.forEach(product -> product.setAvailable(!isSold));
      // Business logic to update products if product is sold
   }

}
