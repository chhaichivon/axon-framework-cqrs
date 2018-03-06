package org.axonframework.web.web;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.web.api.product.ProductEntry;
import org.axonframework.web.api.product.ProductRepository;
import org.axonframework.web.utils.ApiResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;

/**
 * Copyright (c) Group Lease Public Company Limited. All rights reserved. (http://www.grouplease.co.th/)
 * Author: Chhai Chivon (c.chhai@gl-f.com) on 13/10/2017.
 */
@Controller
@RequestMapping(value = "/api")
public class ProductController extends ApiResponse<ProductEntry> {

    private CommandGateway commandGateway;
    private ProductRepository productRepository;

    @Inject
    public ProductController(CommandGateway commandGateway, ProductRepository productRepository) {
        this.commandGateway = commandGateway;
        this.productRepository = productRepository;
    }

    @RequestMapping(value = "/products")
    private ResponseEntity<ProductEntry> findAll(@PathVariable("page") int page, @PathVariable("size") int size){
        Page<ProductEntry> productEntries = productRepository.findAll(new PageRequest(page,size));
        return responseEntity(productEntries);
    }

    @RequestMapping(value = "/products/{id}")
    private ResponseEntity<ProductEntry> findById(@PathVariable("id") Long id){
        ProductEntry productEntry = productRepository.findOne(id);
        return responseEntity(productEntry);
    }

    @RequestMapping(value = "/products", method = RequestMethod.POST)
    private ResponseEntity<ProductEntry> save(@RequestBody ProductEntry productEntry){
        ProductEntry product = productRepository.save(productEntry);
        return responseEntity(product);
    }

    @RequestMapping(value = "/products/{id}", method = RequestMethod.PUT)
    private ResponseEntity<ProductEntry> update(@PathVariable("id") Long id, @RequestBody ProductEntry productEntry){
        ProductEntry product = productRepository.findOne(id);
        if(product != null){
            productEntry.setId(id);
            productRepository.save(productEntry);
        }
        return responseEntity(productEntry);
    }

    @RequestMapping(value = "/products/{id}",  method = RequestMethod.DELETE)
    private ResponseEntity<ProductEntry> delete(@PathVariable("id") Long id){
        ProductEntry productEntry = productRepository.findOne(id);
        if(productEntry != null){
            productRepository.delete(id);
        }
        return responseEntity(productEntry);
    }
}
