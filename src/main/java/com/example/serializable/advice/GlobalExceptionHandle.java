package com.example.serializable.advice;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandle {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String,String>> handleGeneralException(Exception ex) {
        Map<String,String> response = new HashMap<>();
        response.put("error", "Beklenmeyen Bir Hata Oluştu.");
        response.put("details", ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(java.io.NotSerializableException.class)
    public ResponseEntity<Map<String, String>> handleSerializationError(Exception ex) {
        Map<String, String> response = new HashMap<>();
        response.put("error", "Serileştirme hatası oluştu");
        response.put("details", ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(FileNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleFileNotFound(FileNotFoundException ex) {
        Map<String,String> response = new HashMap<>();
        response.put("error", "Beklenmeyen Bir Hata Oluştu.");
        response.put("details", ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
