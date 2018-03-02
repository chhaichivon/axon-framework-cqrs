package org.axonframework.core.product.command;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.core.api.product.ProductCreatedCommand;
import org.axonframework.core.api.product.ProductCreatedEvent;
import org.axonframework.spring.stereotype.Aggregate;

import static org.axonframework.commandhandling.model.AggregateLifecycle.apply;

/**
 * Copyright (c) Group Lease Public Company Limited. All rights reserved. (http://www.grouplease.co.th/)
 * Author: Chhai Chivon (c.chhai@gl-f.com) on 13/10/2017.
 */
@Aggregate
public class Product {

    @SuppressWarnings("unused")
    public Product() {
    }

    @CommandHandler
    public Product(ProductCreatedCommand command){
        apply(new ProductCreatedEvent(command.getProductId(),command.getName(),command.getDescription()));
    }

}
