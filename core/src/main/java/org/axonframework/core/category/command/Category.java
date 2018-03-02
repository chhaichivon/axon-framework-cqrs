package org.axonframework.core.category.command;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.model.AggregateIdentifier;
import org.axonframework.core.api.category.CategoryCreatedCommand;
import org.axonframework.core.api.category.CategoryCreatedEvent;
import org.axonframework.spring.stereotype.Aggregate;

import static org.axonframework.commandhandling.model.AggregateLifecycle.apply;

/**
 * Copyright (c) Group Lease Public Company Limited. All rights reserved. (http://www.grouplease.co.th/)
 * Author: Chhai Chivon (c.chhai@gl-f.com) on 13/10/2017.
 */

@Aggregate
public class Category {

    @AggregateIdentifier
    private String id;

    @SuppressWarnings("unused")
    public Category() {
    }

    @CommandHandler
    public Category(CategoryCreatedCommand categoryCreatedCommand){
        apply(new CategoryCreatedEvent(categoryCreatedCommand.getCategoryId(),categoryCreatedCommand.getName(),categoryCreatedCommand.getDescription()));
    }
}
