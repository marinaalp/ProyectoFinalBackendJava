package com.techlab.productos.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ProductoNoEncontradoException.class)
    public ResponseEntity<Map<String, String>> handleProductoNoEncontrado(ProductoNoEncontradoException ex) {
        Map<String, String> error = new HashMap<>();
        error.put("error", ex.getMessage());
        
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error); // Devuelve 404 Not Found
    }
    
  
    @ExceptionHandler(PrecioInvalidoException.class)
    public ResponseEntity<Map<String, String>> handlePrecioInvalido(PrecioInvalidoException ex) {
        Map<String, String> error = new HashMap<>();
        error.put("error", ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error); // Devuelve 400 Bad Request
    }

    @ExceptionHandler(NombreInvalidoException.class)
    public ResponseEntity<Map<String, String>> handleNombreInvalido(NombreInvalidoException ex) {
        Map<String, String> error = new HashMap<>();
        error.put("error", ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error); // Devuelve 400 Bad Request
    }
}