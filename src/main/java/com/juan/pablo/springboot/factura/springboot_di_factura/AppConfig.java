package com.juan.pablo.springboot.factura.springboot_di_factura;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.juan.pablo.springboot.factura.springboot_di_factura.models.Item;
import com.juan.pablo.springboot.factura.springboot_di_factura.models.Product;

@Configuration
@PropertySource("classpath:data.properties")
public class AppConfig {

    @Bean
    List<Item> itemsInvoice() {

        Product product1 = new Product("Laptop", 1000, "Laptop HP");
        Product product2 = new Product("Mouse", 50, "Mouse Logitech");
        Product product3 = new Product("Keyboard", 30, "Keyboard Logitech");

        return Arrays.asList(new Item(product1, 1), new Item(product2, 2),
                new Item(product3, 3));

    }

}
