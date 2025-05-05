package com.juan.pablo.springboot.factura.springboot_di_factura.models;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;


import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
@RequestScope
//@JsonIgnoreProperties({ "targetSource", "advisors" })
public class Invoice {

    @Autowired
    private Client client;

    @Value("${invoice.description.office}")
    private String description;

    @Autowired
    @Qualifier("default")
    private List<Item> items;

    /**
     * Init method for the invoice bean. This method is called after the
     * properties of the bean have been set.
     */
    @PostConstruct
    public void init() {
        System.out.println("Invoice bean initialized with description: " + description);
        client.setName(client.getName().toUpperCase());
        this.description = description.concat(" del cliente: " + client.getName() + " " + client.getLastname())
                .concat(" " + description);
    }

    /**
     * Destroy method for the invoice bean. This method is called before the
     * bean is destroyed.
     * Used to clean up resources or perform any necessary actions before the bean
     * is
     * destroyed.
     */
    @PreDestroy
    public void destroy() {
        System.out.println("Invoice bean destroyed");
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public int getTotal() {
        int total = 0;
        for (Item item : items) {
            total += item.getImporte();
        }
        return total;
    }
}
