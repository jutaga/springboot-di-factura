package com.juan.pablo.springboot.factura.springboot_di_factura;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.juan.pablo.springboot.factura.springboot_di_factura.models.Item;
import com.juan.pablo.springboot.factura.springboot_di_factura.models.Product;

@Configuration
@PropertySource(value = "classpath:data.properties", encoding = "UTF-8")
public class AppConfig {

    // @Primary
    @Bean
    List<Item> itemsInvoice() {

        Product product1 = new Product("Laptop", 1000, "Laptop HP");
        Product product2 = new Product("Mouse", 50, "Mouse Logitech");
        Product product3 = new Product("Keyboard", 30, "Keyboard Logitech");

        return Arrays.asList(new Item(product1, 1), new Item(product2, 2),
                new Item(product3, 3));

    }

    @Bean("default")
    List<Item> itemsInvoiceOffice() {

        Product product1 = new Product("CPU", 1100, "CPU HP");
        Product product2 = new Product("Silla", 150, "Silla Logitech");
        Product product3 = new Product("Escritorio", 330, "Escritorio Logitech");
        Product product4 = new Product("Monitor", 200, "Monitor HP");

        return Arrays.asList(new Item(product1, 1), new Item(product2, 2),
                new Item(product3, 3), new Item(product4, 4));

    }

}
