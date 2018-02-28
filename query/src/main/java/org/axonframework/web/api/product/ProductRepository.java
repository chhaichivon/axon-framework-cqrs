package org.axonframework.web.api.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Copyright (c) Group Lease Public Company Limited. All rights reserved. (http://www.grouplease.co.th/)
 * Author: Chhai Chivon (c.chhai@gl-f.com) on 13/10/2017.
 */
@Repository
public interface ProductRepository extends JpaRepository<ProductEntry,Long>{
}
