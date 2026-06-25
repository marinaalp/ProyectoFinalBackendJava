package com.techlab.productos.exception;

public class ProductoNoEncontradoException extends RuntimeException{
    public ProductoNoEncontradoException(String mensaje) {
        super(mensaje);
    }
    
}
