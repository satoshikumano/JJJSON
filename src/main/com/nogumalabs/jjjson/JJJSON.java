package com.nogumalabs.jjjson;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public class JJJSON {

    protected JJJSON(){
    }

    public static JJJSON fromObject(Object obj) throws JJJSONException {
        if (obj instanceof JSONObject) {
            return new JJJSONObject((JSONObject) obj);
        } else if (obj instanceof JSONArray) {
            return new JJJSONArray((JSONArray)obj);
        } else if (obj instanceof String) {
            return new JJJSONString((String) obj);
        } else if (obj instanceof Long) {
            return new JJJSONLong((Long) obj);
        } else if (obj instanceof Boolean) {
            return new JJJSONBoolean((Boolean) obj);
        } else if (obj.equals(null)) {
            return new JJJSONNull();
        } else {
            throw new JJJSONException("Specified Object is not acceptable", null);
        }
    }

    public static JJJSON parse(String json) throws JJJSONException {
        try {
            JSONTokener t = new JSONTokener(json);
            Object obj = t.nextValue();
            return JJJSON.fromObject(obj);
        } catch (JSONException e) {
            return null;
        }
    }

    public JJJSON ifObject(WhenValid<JJJSONObject> whenValid) {
        return ifObject(whenValid, null);
    }

    public JJJSON ifObject(WhenValid<JJJSONObject> whenValid, WhenInvalid whenInvalid) {
        if (this instanceof JJJSONObject) {
            whenValid.handle((JJJSONObject)this);
        } else {
            if (whenInvalid != null) {
                whenInvalid.handle();
            }
        }
        return this;
    }

    public JJJSON ifArray(WhenValid<JJJSONArray> whenValid) {
        return ifArray(whenValid, null);
    }

    public JJJSON ifArray(WhenValid<JJJSONArray> whenValid, WhenInvalid whenInvalid) {
        if (this instanceof JJJSONArray) {
            whenValid.handle((JJJSONArray)this);
        } else {
            if (whenInvalid != null) {
                whenInvalid.handle();
            }
        }
        return this;
    }

    public JJJSON ifString(WhenValid<String> whenValid) {
        return ifString(whenValid, null);
    }

    public JJJSON ifString(WhenValid<String> whenValid, WhenInvalid whenInvalid) {
        if (this instanceof JJJSONString) {
            whenValid.handle(((JJJSONString)this).getValue());
        } else {
            if (whenInvalid != null) {
                whenInvalid.handle();
            }
        }
        return this;
    }

    public JJJSON ifDouble(WhenValid<Double> whenValid) {
        return ifDouble(whenValid, null);
    }

    public JJJSON ifDouble(WhenValid<Double> whenValid, WhenInvalid whenInvalid) {
        if (this instanceof JJJSONDouble) {
            whenValid.handle(((JJJSONDouble)this).getValue());
        }
        return this;
    }
    public JJJSON ifLong(WhenValid<Long> whenValid) {
        return this;
    }

    public JJJSON ifLong(WhenValid<Long> whenValid, WhenInvalid whenInvalid) {
        return this;
    }

    public JJJSON ifBoolean(WhenValid<Boolean> whenValid) {
        return this;
    }

    public JJJSON ifBoolean(WhenValid<Boolean> whenValid, WhenInvalid whenInvalid) {
        return this;
    }

    public JJJSON ifNull(WhenValid<JJJSONNull> whenValid) {
        return this;
    }

    public JJJSON ifNull(WhenValid<JJJSONNull> whenValid, WhenInvalid whenInvalid) {
        return this;
    }
}
