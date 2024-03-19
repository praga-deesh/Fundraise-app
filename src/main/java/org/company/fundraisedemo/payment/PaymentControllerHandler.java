package org.company.fundraisedemo.payment;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class PaymentControllerHandler {
    @ExceptionHandler(value = PaymentExceptions.class)
    public ResponseEntity<String> paymentExceptionHandler(PaymentExceptions e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
