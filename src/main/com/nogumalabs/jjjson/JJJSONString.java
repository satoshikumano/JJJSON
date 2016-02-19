package com.nogumalabs.jjjson;

public class JJJSONString extends JJJSON {
    private String rawValue;

    public JJJSONString(String rawValue) {
        this.rawValue = rawValue;
    }

    public String getValue() {
        return rawValue;
    }

}
