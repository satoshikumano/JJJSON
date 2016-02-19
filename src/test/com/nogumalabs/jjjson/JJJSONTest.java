package com.nogumalabs.jjjson;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class JJJSONTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testUsage() throws Exception {
        String jsonStr = "{\"key1\": \"value1\"}";
        JJJSON json = JJJSON.parse(jsonStr);
        assert json != null;

        json.ifObject(new WhenValid<JJJSONObject>() {
            @Override
            public void handle(JJJSONObject value) {
                value.getString("key1", new WhenValid<String>() {
                    @Override
                    public void handle(String value) {
                        assertEquals("value1", value);
                    }
                });
            }
        }, new WhenInvalid() {
            @Override
            public void handle() {
                fail();;
            }
        });
    }
}