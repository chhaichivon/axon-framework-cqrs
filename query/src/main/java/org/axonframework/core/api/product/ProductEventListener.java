package org.axonframework.core.api.product;

import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Component;

/**
 * Copyright (c) Group Lease Public Company Limited. All rights reserved. (http://www.grouplease.co.th/)
 * Author: Chhai Chivon (c.chhai@gl-f.com) on 13/10/2017.
 */
@Component
public class ProductEventListener {

    private ProductRepository productRepository;
    private SimpMessageSendingOperations messageSendingOperations;

    @Autowired
    public ProductEventListener(ProductRepository productRepository, SimpMessageSendingOperations messageSendingOperations) {
        this.productRepository = productRepository;
        this.messageSendingOperations = messageSendingOperations;
    }

    @EventHandler
    public void on(ProductCreatedEvent event){
        productRepository.save(new ProductEntry(event.getProductId(),event.getName(),event.getDescription()));
    }
}
