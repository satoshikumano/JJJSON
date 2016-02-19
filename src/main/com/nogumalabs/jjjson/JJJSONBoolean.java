package com.nogumalabs.jjjson;

public class JJJSONBoolean extends JJJSON {
    private boolean rawValue;
    public JJJSONBoolean(boolean rawValue) {
        this.rawValue = rawValue;
    }
    public boolean getValue() {
        return rawValue;
    }
}
