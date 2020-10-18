package com.tomtom.demo.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class ApplicationExceptionHandler {

   private static final Logger LOG = LoggerFactory.getLogger(ApplicationExceptionHandler.class);

   @ExceptionHandler(value = {OrderProcessingException.class})
   protected ResponseEntity<ErrorResponse> handleProcessingExceptions(OrderProcessingException ex, WebRequest request) {
      LOG.error("Intercepted BAD Request Exception in exception handler: {}", request, ex);
      ErrorResponse errorResponse = generateErrorResponse(ex, HttpStatus.CONFLICT, request);
      return new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT);
   }

   protected HttpHeaders getHttpHeaders() {
      HttpHeaders httpHeaders = new HttpHeaders();
      httpHeaders.setContentType(MediaType.APPLICATION_JSON);
      return httpHeaders;
   }

   private ErrorResponse generateErrorResponse(Exception ex, HttpStatus httpStatus, WebRequest request) {

      ErrorResponse errorResponse = new ErrorResponse();
      errorResponse.setTimestamp(new Date());
      errorResponse.setError(httpStatus.getReasonPhrase());
      errorResponse.setMessage(ex.getMessage());

      return errorResponse;
   }

   @Getter
   @Setter
   @JsonInclude(JsonInclude.Include.NON_NULL)
   private static class ErrorResponse {
      private Date timestamp;
      private String error;
      private String message;
      private RuntimeException exception;
   }
}


