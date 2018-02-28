package org.axonframework.web.api.product;

import lombok.Value;

/**
 * Copyright (c) Group Lease Public Company Limited. All rights reserved. (http://www.grouplease.co.th/)
 * Author: Chhai Chivon (c.chhai@gl-f.com) on 13/10/2017.
 */
@Value
public class ProductCreatedEvent {

    private String productId;
    private String name;
    private String description;
}
