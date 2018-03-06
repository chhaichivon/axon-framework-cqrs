package org.axonframework.web.web;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.web.api.category.CategoryRepository;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

import javax.inject.Inject;

/**
 * Copyright (c) Group Lease Public Company Limited. All rights reserved. (http://www.grouplease.co.th/)
 * Author: Chhai Chivon (c.chhai@gl-f.com) on 13/10/2017.
 */

@Controller
@MessageMapping(value = "/api/categories")
public class CategoryController {

    private final CategoryRepository categoryRepository;
    private final CommandGateway commandGateway;

    @Inject
    public CategoryController(CategoryRepository categoryRepository, CommandGateway commandGateway) {
        this.categoryRepository = categoryRepository;
        this.commandGateway = commandGateway;
    }
}
