package org.axonframework.web.utils;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Copyright (c) Group Lease Public Company Limited. All rights reserved. (http://www.grouplease.co.th/)
 * Author: Chhai Chivon (c.chhai@gl-f.com) on 13/10/2017.
 */
public class ApiResponse<T> {

    private static final String SUCCESS = "success";
    private static final String FAIL = "fail";
    private Map<String, Object> map;

    private Map getMessage(boolean success) {
        map = new HashMap<>();
        if (success) {
            map.put("message", SUCCESS);
            map.put("status", 200);
            return map;
        } else {
            map.put("message", FAIL);
            map.put("status", 400);
            return map;
        }
    }

    private Map getMapFail() {
        map = new HashMap<>();
        map.putAll(getMessage(false));
        return map;
    }

    private Map getMapPageSuccess(Page<T> entities) {
        map = new HashMap<>();
        map.put("data", entities);
        map.putAll(getMessage(true));
        return map;
    }

    private Map getMapListSuccess(List<T> entities) {
        map = new HashMap<>();
        map.put("data", entities);
        map.putAll(getMessage(true));
        return map;
    }

    private Map getMapObjectSuccess(T entities) {
        map = new HashMap<>();
        map.put("data", entities);
        map.putAll(getMessage(true));
        return map;
    }

    public ResponseEntity<T> responseEntity(Page<T> entities) {
        if (entities.hasContent()) {
            return new ResponseEntity<>((T) getMapPageSuccess(entities), HttpStatus.OK);
        }else{
            return new ResponseEntity<>((T) getMapFail(), HttpStatus.OK);
        }
    }
    public ResponseEntity<T> responseEntity(List<T> entities) {
        if (entities != null) {
            return new ResponseEntity<>((T) getMapListSuccess(entities), HttpStatus.OK);
        }else{
            return new ResponseEntity<>((T) getMapFail(), HttpStatus.OK);
        }
    }
    public ResponseEntity<T> responseEntity(T entities) {
        if (entities != null) {
            return new ResponseEntity<>((T) getMapObjectSuccess(entities), HttpStatus.OK);
        }else{
            return new ResponseEntity<>((T) getMapFail(), HttpStatus.OK);
        }
    }
}
