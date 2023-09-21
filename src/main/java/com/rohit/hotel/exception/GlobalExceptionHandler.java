package com.rohit.hotel.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Map<String, Object>> notFoundException(ResourceNotFoundException ex){
        //userService me mene Map ki jagha ApiResponse class bnai hai message status or success exception handle ke liye yha mene map ka use kia hai wha bhi kr skte the
        Map map= new HashMap();
        map.put("message",ex.getMessage());
        map.put("success",false);
        map.put("status", HttpStatus.NOT_FOUND);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(map);
    }
}
