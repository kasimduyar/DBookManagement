package com.works.utils;

import com.works.entities.Customer;

import java.util.UUID;

public class SecurityUtil {

    public static Customer customerSession = null;

    public String userRandomID() {
        String uuid = UUID.randomUUID().toString();
        return uuid;
    }
}