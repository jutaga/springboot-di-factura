package com.juan.pablo.springboot.factura.springboot_di_factura.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.juan.pablo.springboot.factura.springboot_di_factura.models.Client;
import com.juan.pablo.springboot.factura.springboot_di_factura.models.Invoice;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/invoices")
public class InvoiceController {

    @Autowired
    private Invoice invoice;

    @GetMapping("/show")
    public Invoice show() {

        Invoice invoice = new Invoice();
        Client client = new Client();
        client.setName(this.invoice.getClient().getName());
        client.setLastname(this.invoice.getClient().getLastname());
        client.setEmail(this.invoice.getClient().getEmail());
        client.setPhoneNumber(this.invoice.getClient().getPhoneNumber());
        invoice.setClient(client);
        invoice.setDescription(this.invoice.getDescription());
        invoice.setItems(this.invoice.getItems());
        return invoice;
    }

}
