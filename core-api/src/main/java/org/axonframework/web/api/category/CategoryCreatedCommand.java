package org.axonframework.web.api.category;

import lombok.Value;
import org.axonframework.commandhandling.TargetAggregateIdentifier;

/**
 * Copyright (c) Group Lease Public Company Limited. All rights reserved. (http://www.grouplease.co.th/)
 * Author: Chhai Chivon (c.chhai@gl-f.com) on 13/10/2017.
 */
@Value
public class CategoryCreatedCommand {

    @TargetAggregateIdentifier
    private String categoryId;
    private String name;
    private String description;
}
