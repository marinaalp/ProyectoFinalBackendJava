package com.techlab.productos.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.techlab.productos.model.Producto;


public interface ProductoRepository extends JpaRepository<Producto, String> {
    List<Producto> findByTitleContainingIgnoreCase(String title);
    
}
