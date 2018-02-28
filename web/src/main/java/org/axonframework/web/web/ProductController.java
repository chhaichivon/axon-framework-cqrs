package org.axonframework.web.web;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.web.api.product.ProductEntry;
import org.axonframework.web.api.product.ProductRepository;
import org.axonframework.web.utils.ApiResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Copyright (c) Group Lease Public Company Limited. All rights reserved. (http://www.grouplease.co.th/)
 * Author: Chhai Chivon (c.chhai@gl-f.com) on 13/10/2017.
 */
@Controller
@RequestMapping(value = "/api")
public class ProductController extends ApiResponse<ProductEntry> {

    private CommandGateway commandGateway;
    private ProductRepository productRepository;

    public ProductController(CommandGateway commandGateway, ProductRepository productRepository) {
        this.commandGateway = commandGateway;
        this.productRepository = productRepository;
    }

    @RequestMapping(value = "/products")
    private ResponseEntity<Page<ProductEntry>> findAll(@PathVariable("page") int page,@PathVariable("size") int size){
        Page<ProductEntry> productEntries = productRepository.findAll(new PageRequest(page,size));
        return new ResponseEntity<>(productEntries, HttpStatus.OK);
    }

}
