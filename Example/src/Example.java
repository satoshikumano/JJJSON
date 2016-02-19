import com.nogumalabs.jjjson.JJJSON;
import com.nogumalabs.jjjson.JJJSONException;
import com.nogumalabs.jjjson.JJJSONObject;
import com.nogumalabs.jjjson.WhenValid;

import java.util.Random;

public class Example {

    public static void main(String args[]) {
        // Example of parsing loosely typed JSONObject.
        String jsonObjectStr1 = "{\"key1\" : \"value1\"}";
        String jsonObjectStr2 = "{\"key1\" : 1}";

        // Assume the situation you don't know the whether the key1 is string or number.
        Random r = new Random();
        int num = r.nextInt(2);
        String actual = (num == 0 ? jsonObjectStr1 : jsonObjectStr2);

        try {
            JJJSON json = JJJSON.parse(actual);
            assert (json != null);
            json.ifObject(new WhenValid<JJJSONObject>() {
                @Override
                public void handle(JJJSONObject value) {
                    value.getString("key1", new WhenValid<String>() {
                        @Override
                        public void handle(String value) {
                            System.out.println("value is " + value);
                        }
                    }).getLong("key1", new WhenValid<Long>() {
                        @Override
                        public void handle(Long value) {
                            System.out.println("value is " + value);
                        }
                    });
                }
            });
        } catch (JJJSONException e) {
            assert (false);
        }

    }

}