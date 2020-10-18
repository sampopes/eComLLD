package com.tomtom.demo.controller;

import com.tomtom.demo.model.Order;
import com.tomtom.demo.service.OrderService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@Service
public class OrderController {
   @Autowired
   private OrderService orderService;


   @ApiOperation(value = "Take an order for processing", nickname = "putOrder", notes = "", response = String.class, tags = {"Order service"})
   @ApiResponses(value = {
           @ApiResponse(code = 200, message = "Order processed successfully", response = String.class, responseContainer = "List"),
           @ApiResponse(code = 400, message = "Malformed or Bad Request."),
           @ApiResponse(code = 401, message = "Unauthorized."),
           @ApiResponse(code = 409, message = "Conflict in order state."),
           @ApiResponse(code = 405, message = "Validation exception"),
           @ApiResponse(code = 413, message = "Request Payload is Too Large.")})
   @RequestMapping(value = "/api/order",
           produces = {"application/json"},
           consumes = {"application/json"},
           method = RequestMethod.PUT)
   ResponseEntity<UUID> createOrder(@ApiParam(value = "Order object that needs to be added or updated", required = true) @Valid @RequestBody UUID cartId
   ) {
      // process order
      // redirect to payment gateway
      // set order status to failed of success
      return new ResponseEntity<UUID>(this.orderService.createOrder(cartId).getOrderId(), HttpStatus.OK);
   }
}
