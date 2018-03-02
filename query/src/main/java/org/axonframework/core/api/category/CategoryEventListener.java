package org.axonframework.core.api.category;

import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Component;

/**
 * Copyright (c) Group Lease Public Company Limited. All rights reserved. (http://www.grouplease.co.th/)
 * Author: Chhai Chivon (c.chhai@gl-f.com) on 13/10/2017.
 */
@Component
public class CategoryEventListener {

    private CategoryRepository categoryRepository;
    private SimpMessageSendingOperations messageSendingOperations;

    @Autowired
    public CategoryEventListener(CategoryRepository categoryRepository, SimpMessageSendingOperations messageSendingOperations) {
        this.categoryRepository = categoryRepository;
        this.messageSendingOperations = messageSendingOperations;
    }

    @EventHandler
    public void on(CategoryCreatedEvent event){
        categoryRepository.save(new CategoryEntry(event.getCategoryId(),event.getName(),event.getDescription()));
    }
}
