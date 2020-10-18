package com.tomtom.demo.controller;

import com.tomtom.demo.model.Product;
import com.tomtom.demo.service.CartService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
public class CartController {
   @Autowired
   private CartService cartService;

   @ApiOperation(value = "Update an existing cart else create a new cart and return cartId", nickname = "putCart", notes = "", response = UUID.class, tags = {"Cart service",})
   @ApiResponses(value = {
           @ApiResponse(code = 200, message = "Products added to cart successfully", response = UUID.class),
           @ApiResponse(code = 400, message = "Malformed or Bad Request."),
           @ApiResponse(code = 401, message = "Unauthorized."),
           @ApiResponse(code = 405, message = "Validation exception"),
           @ApiResponse(code = 413, message = "Request Payload is Too Large.")})
           @RequestMapping(value = "/api/cart/{customerId}",
           produces = {"application/json"},
           consumes = {"application/json"},
           method = RequestMethod.PUT)
   ResponseEntity<UUID> updateCart(@ApiParam(value = "Product object that needs to be added or updated", required = true) @Valid @RequestBody List<Product> productList , @PathVariable("customerId") UUID customerId
   ) {
      return new ResponseEntity<UUID>(this.cartService.updateCart(productList , customerId), HttpStatus.OK);
   }
}
