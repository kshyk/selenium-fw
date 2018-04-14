package com.kshyk;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.UUID;

public class App {

    private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        App obj = new App();
        LOGGER.info("Unique ID : " + obj.generateUniqueKey());
    }

    public String generateUniqueKey() {
        return UUID.randomUUID().toString();
    }
}