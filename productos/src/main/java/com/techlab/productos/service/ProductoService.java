package com.techlab.productos.service; 

import com.techlab.productos.exception.ProductoNoEncontradoException;
import com.techlab.productos.exception.NombreInvalidoException;
import com.techlab.productos.exception.PrecioInvalidoException;
import com.techlab.productos.model.Producto; // Importamos el nuevo modelo de Producto
import org.springframework.stereotype.Service;
import com.techlab.productos.repository.ProductoRepository;

import java.util.List;

@Service
public class ProductoService {
    private final ProductoRepository productoRepository;

    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    public List<Producto> listarTodos() {
        return productoRepository.findAll();
    }

    public Producto obtenerPorId(String id) {
        // Comparamos usando .equals() porque ahora el ID es un String
        return productoRepository.findById(id)
                .orElseThrow(() -> new ProductoNoEncontradoException("No se encontró un producto con id " + id));
    }

    public Producto guardar(Producto producto) {
    // 1. Si el producto NO tiene ID, significa que es un CREAR (POST)
    if (producto.getId() == null || producto.getId().isBlank()) {
        long maxId = productoRepository.findAll()
                .stream()
                .mapToLong(p -> {
                    try {
                        return Long.parseLong(p.getId());
                    } catch (NumberFormatException e) {
                        return 0; // Por si te quedó algún UUID viejo dando vueltas
                    }
                })
                .max()
                .orElse(0); // Si la tabla está vacía, arranca en 0
        
        // Le asignamos el número siguiente como String (ej: "1", "2", "3")
        producto.setId(String.valueOf(maxId + 1));
    }

    // 2. Validaciones que ya tenías
    if (producto.getTitle() == null || producto.getTitle().isBlank()) {
        throw new NombreInvalidoException("El título del producto no puede estar vacío.");
    }
    if (producto.getPrice() <= 0) {
        throw new PrecioInvalidoException("El precio debe ser mayor a 0.");
    }
    if (producto.getImage() == null || producto.getImage().isBlank()) {
        producto.setImage("https://www.shutterstock.com/image-vector/cute-cat-confused-cartoon-vector-600nw-2350423433.jpg");
    }

    return productoRepository.save(producto);
}

    public void eliminar(String id) {
        Producto producto = obtenerPorId(id);
        productoRepository.delete(producto);
    }
    public Producto actualizar(String id, Producto datosNuevos) {
    // 1. Buscamos el que ya existe
    Producto productoExistente = obtenerPorId(id);
    
    // 2. Validamos los datos nuevos antes de plancharlos
    if (datosNuevos.getTitle() == null || datosNuevos.getTitle().isBlank()) {
        throw new NombreInvalidoException("El título del producto no puede estar vacío.");
    }
    if (datosNuevos.getPrice() <= 0) {
        throw new PrecioInvalidoException("El precio debe ser mayor a 0.");
    }

    // 3. Le pasamos los datos nuevos al existente (manteniendo su ID intacto)
    productoExistente.setTitle(datosNuevos.getTitle());
    productoExistente.setPrice(datosNuevos.getPrice());
    productoExistente.setCategory(datosNuevos.getCategory());
    
    if (datosNuevos.getImage() == null || datosNuevos.getImage().isBlank()) {
        productoExistente.setImage("https://www.shutterstock.com/image-vector/cute-cat-confused-cartoon-vector-600nw-2350423433.jpg");
    } else {
        productoExistente.setImage(datosNuevos.getImage());
    }

    // 4. Guardamos la entidad gestionada por JPA
    return productoRepository.save(productoExistente);
}
}