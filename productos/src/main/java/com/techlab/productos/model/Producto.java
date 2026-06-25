package com.techlab.productos.model;
import lombok.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

@Entity
@Table(name = "producto")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Producto {
    @Id
    private String id;
    @NotBlank(message = "El nombre del producto no puede estar vacío.")
    @Column(name = "title", nullable = false, length = 100)
    private String title;
    @Column(name = "description", nullable = true, columnDefinition = "TEXT")
    private String description;
    @Positive(message = "El precio debe ser mayor a 0.")
    @Column(name = "price", nullable = false)
    private double price;
    @Column(name = "image", nullable = true)
    private String image;
    @NotBlank(message = "La categoría del producto no puede estar vacía.")
    @Column(name = "category", nullable = false, length = 50)
    private String category;
    
}
