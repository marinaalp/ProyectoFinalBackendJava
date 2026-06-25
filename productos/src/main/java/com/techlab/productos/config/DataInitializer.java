package com.techlab.productos.config;

import com.techlab.productos.model.Producto;
import com.techlab.productos.service.ProductoService;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final ProductoService productoService;

    // El constructor solo recibe el servicio
    public DataInitializer(ProductoService productoService) {
        this.productoService = productoService;
    }

    @Override
    public void run(String... args) throws Exception {
        
        // CORRECCIÓN: Usamos el servicio para verificar si está vacío
        if (productoService.listarTodos().isEmpty()) {
            
            productoService.guardar(new Producto(
                null, 
                "Fjallraven - Foldsack No. 1 Backpack, Fits 15 Laptops", 
                "Your perfect pack for everyday use and walks in the forest. Stash your laptop (up to 15 inches) in the padded sleeve, your everyday",
                109.95, 
                "https://fakestoreapi.com/img/81fPKd-2AYL._AC_SL1500_t.png", 
                "men's clothing"
            ));
            
            productoService.guardar(new Producto(
                null, 
                "Mens Casual Premium Slim Fit T-Shirts",
                "Slim-fitting style, contrast raglan long sleeve, three-button henley placket, light weight & soft fabric for breathable and comfortable wearing. And Solid stitched shirts with round neck made for durability and a great fit for casual fashion wear and diehard baseball fans. The Henley style round neckline includes a three-button placket.",
                22.3, 
                "https://fakestoreapi.com/img/71-3HjGNDUL._AC_SY879._SX._UX._SY._UY_t.png", 
                "men's clothing"
            ));
            
            productoService.guardar(new Producto(
                null, 
                "John Hardy Women's Legends Naga Gold & Silver Dragon Station Chain Bracelet", 
                "From our Legends Collection, the Naga was inspired by the mythical water dragon that protects the ocean's pearl. Wear facing inward to be bestowed with love and abundance, or outward for protection.",
                695.0, 
                "https://fakestoreapi.com/img/71pWzhdJNwL._AC_UL640_QL65_ML3_t.png", 
                "jewelery"
            ));
            
            productoService.guardar(new Producto(
                null, 
                "Solid Gold Petite Micropave", 
                "Satisfaction Guaranteed. Return or exchange any order within 30 days.Designed and sold by Hafeez Center in the United States. Satisfaction Guaranteed. Return or exchange any order within 30 days.",
                168.0, 
                "https://fakestoreapi.com/img/61sbMiUnoGL._AC_UL640_QL65_ML3_t.png", 
                "jewelery"
            ));
            
            productoService.guardar(new Producto(
                null, 
                "WD 2TB Elements Portable External Hard Drive - USB 3.0", 
                "USB 3.0 and USB 2.0 Compatibility Fast data transfers Improve PC Performance High Capacity; Compatibility Formatted NTFS for Windows 10, Windows 8.1, Windows 7; Reformatting may be required for other operating systems; Compatibility may vary depending on user’s hardware configuration and operating system",
                64.0, 
                "https://fakestoreapi.com/img/61IBBVJvSDL._AC_SY879_t.png", 
                "electronics"
            ));
            
            productoService.guardar(new Producto(
                null, 
                "SanDisk SSD PLUS 1TB Internal SSD - SATA III 6 Gb/s", 
                "Easy upgrade for faster boot up, shutdown, application load and response (As compared to 5400 RPM SATA 2.5” hard drive; Based on published specifications and internal benchmarking tests using PCMark vantage scores) Boosts burst write performance, making it ideal for typical PC workloads The perfect balance of performance and reliability Read/write speeds of up to 535MB/s/450MB/s (Based on internal testing; Performance may vary depending upon drive capacity, host device, OS and application.)",
                109.0, 
                "https://fakestoreapi.com/img/61U7T1koQqL._AC_SX679_t.png", 
                "electronics"
            ));
            
            productoService.guardar(new Producto(
                null, 
                "BIYLACLESEN Women's 3-in-1 Snowboard Jacket Winter Coats", 
                "Note:The Jackets is US standard size, Please choose size as your usual wear Material: 100% Polyester; Detachable Liner Fabric: Warm Fleece. Detachable Functional Liner: Skin Friendly, Lightweigt and Warm.Stand Collar Liner jacket, keep you warm in cold weather. Zippered Pockets: 2 Zippered Hand Pockets, 2 Zippered Pockets on Chest (enough to keep cards or keys)and 1 Hidden Pocket Inside.Zippered Hand Pockets and Hidden Pocket keep your things secure. Humanized Design: Adjustable and Detachable Hood and Adjustable cuff to prevent the wind and water,for a comfortable fit. 3 in 1 Detachable Design provide more convenience, you can separate the coat and inner as needed, or wear it together. It is suitable for different season and help you adapt to different climates",
                56.99, 
                "https://fakestoreapi.com/img/51Y5NI-I5jL._AC_UX679_t.png", 
                "women's clothing"
            ));
            
            productoService.guardar(new Producto(
                null, 
                "Rain Jacket Women Windbreaker Striped Climbing Raincoats", 
                "Lightweight perfet for trip or casual wear---Long sleeve with hooded, adjustable drawstring waist design. Button and zipper front closure raincoat, fully stripes Lined and The Raincoat has 2 side pockets are a good size to hold all kinds of things, it covers the hips, and the hood is generous but doesn't overdo it.Attached Cotton Lined Hood with Adjustable Drawstrings give it a real styled look.",
                39.99, 
                "https://fakestoreapi.com/img/71HblAHs5xL._AC_UY879_-2t.png", 
                "women's clothing"
            ));

            System.out.println("¡Productos de ropa, joyería y electrónica cargados correctamente desde tu MockAPI con IDs secuenciales!");
        }
    }
}