package org.axonframework.web.api.product;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Copyright (c) Group Lease Public Company Limited. All rights reserved. (http://www.grouplease.co.th/)
 * Author: Chhai Chivon (c.chhai@gl-f.com) on 13/10/2017.
 */
@Entity
public class ProductEntry {

    @Id
    @GeneratedValue
    private Long id;
    private String productId;
    private String name;
    private String description;

    public ProductEntry(String productId, String name, String description) {
        this.productId = productId;
        this.name = name;
        this.description = description;
    }
}
