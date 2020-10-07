package com.example.library.Data.Entity;

import org.json.JSONObject;

public abstract class AbstractModel<T> {
    abstract T convertFromJSonToObject(JSONObject object);
}
