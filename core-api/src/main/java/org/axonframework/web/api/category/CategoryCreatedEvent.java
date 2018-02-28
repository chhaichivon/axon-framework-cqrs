package org.axonframework.web.api.category;

import lombok.Value;

/**
 * Copyright (c) Group Lease Public Company Limited. All rights reserved. (http://www.grouplease.co.th/)
 * Author: Chhai Chivon (c.chhai@gl-f.com) on 13/10/2017.
 */
@Value
public class CategoryCreatedEvent {
    private String categoryId;
    private String name;
    private String description;


    public CategoryCreatedEvent(String categoryId, String name, String description) {
        this.categoryId = categoryId;
        this.name = name;
        this.description = description;
    }
}
