package com.tomtom.demo.controller;

import com.tomtom.demo.model.Product;
import com.tomtom.demo.service.ProductService;
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

@RestController
public class ProductController {

   @Autowired
   private ProductService productService;

   @ApiOperation(value = "Update an existing product or adds if not present", nickname = "putProduct", notes = "", response = Product.class, responseContainer = "List", tags = {"Product service",})
   @ApiResponses(value = {
           @ApiResponse(code = 200, message = "Product added successfully", response = Product.class, responseContainer = "List"),
           @ApiResponse(code = 400, message = "Malformed or Bad Request."),
           @ApiResponse(code = 401, message = "Unauthorized."),
           @ApiResponse(code = 405, message = "Validation exception"),
           @ApiResponse(code = 413, message = "Request Payload is Too Large.")})
   @RequestMapping(value = "/api/product/{sellerId}",
           produces = {"application/json"},
           consumes = {"application/json"},
           method = RequestMethod.PUT)
   ResponseEntity<String> putProduct(@ApiParam(value = "Product object that needs to be added or updated", required = true) @Valid @RequestBody List<Product> productList,
                                     @PathVariable("sellerId") int sellerId
   ) {
      return new ResponseEntity<String>(this.productService.addProducts(productList, sellerId), HttpStatus.OK);
   }


   @ApiOperation(value = "Find products by product type", nickname = "getProductsByProductType", notes = "Returns products", response = Product.class, responseContainer = "List", tags = {"Product service",})
   @ApiResponses(value = {
           @ApiResponse(code = 200, message = "request processed successfully, resources found", response = Product.class, responseContainer = "List"),
           @ApiResponse(code = 204, message = "request processed successfully, no resources found"),
           @ApiResponse(code = 400, message = "Malformed or Bad Request."),
           @ApiResponse(code = 401, message = "Unauthorized."),
           @ApiResponse(code = 500, message = "Server error while processing the request")})
   @RequestMapping(value = "/api/product/{productType}",
           produces = {"application/json"},
           method = RequestMethod.GET)
   ResponseEntity<List<Product>> getProductsByType(@ApiParam(value = "product type identifying the target products", required = true) @PathVariable("productType") String type
   ) {
      return new ResponseEntity<List<Product>>(this.productService.getProductsByType(type), HttpStatus.OK);
   }

}
