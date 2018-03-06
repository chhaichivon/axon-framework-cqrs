package org.axonframework.web.api.category;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Copyright (c) Group Lease Public Company Limited. All rights reserved. (http://www.grouplease.co.th/)
 * Author: Chhai Chivon (c.chhai@gl-f.com) on 13/10/2017.
 */
@Entity
public class CategoryEntry {

    @Id
    @GeneratedValue
    private Long id;
    private String categoryId;
    private String name;
    private String description;

    public CategoryEntry(String categoryId,String name, String description) {
        this.categoryId = categoryId;
        this.name = name;
        this.description = description;
    }
}
