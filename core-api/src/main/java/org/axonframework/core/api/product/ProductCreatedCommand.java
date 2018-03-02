package org.axonframework.core.api.product;

import lombok.Value;
import org.axonframework.commandhandling.TargetAggregateIdentifier;

/**
 * Copyright (c) Group Lease Public Company Limited. All rights reserved. (http://www.grouplease.co.th/)
 * Author: Chhai Chivon (c.chhai@gl-f.com) on 13/10/2017.
 */
@Value
public class ProductCreatedCommand {

    @TargetAggregateIdentifier
    private String productId;
    private String name;
    private String description;
}
