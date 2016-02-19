package com.nogumalabs.jjjson;

import org.json.JSONArray;

public class JJJSONArray extends JJJSON {
    private JSONArray rawValue;
    public JJJSONArray(JSONArray rawValue) {
        this.rawValue = rawValue;
    }
}
