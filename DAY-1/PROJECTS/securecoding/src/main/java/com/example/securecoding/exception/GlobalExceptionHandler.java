package com.example.securecoding.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class GlobalExceptionHandler {

@ExceptionHandler(MethodArgumentNotValidException.class)
public ResponseEntity<String> validationError(){

return ResponseEntity
.status(HttpStatus.BAD_REQUEST)
.body("Invalid request data");

}

@ExceptionHandler(Exception.class)
public ResponseEntity<String> handleError(){

return ResponseEntity
.status(HttpStatus.INTERNAL_SERVER_ERROR)
.body("Internal Server Error");

}
}
