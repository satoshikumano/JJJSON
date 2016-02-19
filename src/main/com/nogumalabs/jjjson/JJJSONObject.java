package com.nogumalabs.jjjson;

import org.json.JSONException;
import org.json.JSONObject;

public class JJJSONObject extends JJJSON {
    private JSONObject rawValue;

    public JJJSONObject(JSONObject rawValue) {
        this.rawValue = rawValue;
    }

    public JJJSONObject has(String key, WhenValid<Void> whenValid) {
        if (rawValue.has(key)) {
            whenValid.handle(null);
        }
        return this;
    }

    public JJJSONObject has(String key, WhenInvalid whenInvalid) {
        if (!rawValue.has(key)) {
            whenInvalid.handle();
        }
        return  this;
    }

    public JJJSONObject getString(String key, WhenValid<String> whenValid) {
        return getString(key, whenValid, null);
    }

    public JJJSONObject getString(String key, WhenValid<String> whenValid, WhenInvalid whenInvalid) {
        try {
            Object obj = rawValue.get(key);
            if (obj instanceof String) {
                whenValid.handle((String)obj);
            } else {
                if (whenInvalid != null) {
                    whenInvalid.handle();
                }
            }
        } catch (JSONException e) {
            if (whenInvalid != null) {
                whenInvalid.handle();
            }
        }
        return this;
    }

    public JJJSONObject getDouble(String key, WhenValid<Double> whenValid) {
        return getDouble(key, whenValid, null);
    }

    public JJJSONObject getDouble(String key, WhenValid<Double> whenValid, WhenInvalid whenInvalid) {
        try {
            Object obj = rawValue.get(key);
            if (obj instanceof Number) {
                whenValid.handle(((Number) obj).doubleValue());
            } else {
                if (whenInvalid != null) {
                    whenInvalid.handle();
                }
            }
        } catch (JSONException e) {
            if (whenInvalid != null) {
                whenInvalid.handle();
            }
        }
        return this;
    }

    public JJJSONObject getLong(String key, WhenValid<Long> whenValid) {
        return getLong(key, whenValid, null);
    }

    public JJJSONObject getLong(String key, WhenValid<Long> whenValid, WhenInvalid whenInvalid) {
        try {
            Object obj = rawValue.get(key);
            if (obj instanceof Number) {
                whenValid.handle((Long) ((Number) obj).longValue());
            } else {
                if (whenInvalid != null) {
                    whenInvalid.handle();
                }
            }
        } catch (JSONException e) {
            if (whenInvalid != null) {
                whenInvalid.handle();
            }
        }
        return this;
    }

    public JJJSONObject getBoolean(String key, WhenValid<Boolean> whenValid) {
        return getBoolean(key, whenValid, null);
    }

    public JJJSONObject getBoolean(String key, WhenValid<Boolean> whenValid, WhenInvalid whenInvalid) {
        try {
            Boolean v = rawValue.getBoolean(key);
            whenValid.handle(v);
        } catch (JSONException e) {
            if (whenInvalid != null) {
                whenInvalid.handle();
            }
        }
        return this;
    }

    public JJJSONObject isNull(String key, WhenValid<Void> whenValid) {
        try {
            Object v = rawValue.get(key);
            if (v.equals(null)) {
                whenValid.handle(null);
            }
        } catch (JSONException e) {
        }
        return this;
    }

    public JJJSONObject isNull(String key, WhenInvalid whenInvalid) {
        try {
            Object v = rawValue.get(key);
            if (!v.equals(null)) {
                whenInvalid.handle();
            }
        } catch (JSONException e) {
            whenInvalid.handle();
        }
        return this;
    }

}

