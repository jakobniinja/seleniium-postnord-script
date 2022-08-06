package com.jakobniinja.postnordscript;

import org.springframework.beans.factory.annotation.Value;

public class SeleniumConfig {
    @Value("${postkod}")
    private String postkod;

    public String getPostkod() {
        return postkod;
    }

    public void setPostkod(String postkod) {
        this.postkod = postkod;
    }
}
