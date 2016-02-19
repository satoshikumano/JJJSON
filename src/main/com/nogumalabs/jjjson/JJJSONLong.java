package com.nogumalabs.jjjson;

public class JJJSONLong extends JJJSON {

    private long rawValue;

    public JJJSONLong(long rawValue) {
        this.rawValue = rawValue;
    }

    public long getValue() {
        return rawValue;
    }

}
