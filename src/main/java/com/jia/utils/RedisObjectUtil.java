package com.jia.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class RedisObjectUtil {

    public static <T> List<T> convertToList(Object object, Class<T> c) {
        List<T> list = new ArrayList<>();
        JSONArray jsonArray = convertToJsonArray(object);
        for (Object o : jsonArray) {
            JSONObject jsonObject = convertToJsonObject(o);
            T m = jsonObject.toJavaObject(c);
            list.add(m);
        }
        return list;

    }

    public static <T> T convertToJavaBean(Object object, Class<T> c) {
        JSONObject jsonObject = convertToJsonObject(object);
        return jsonObject.toJavaObject(c);
    }

    private static JSONObject convertToJsonObject(Object data) {
        if (data == null) {
            return null;
        }
        if (data instanceof JSONObject) {
            return (JSONObject)data;
        } if (data instanceof String) {
            return JSONObject.parseObject((String)data);
        } else {
            return (JSONObject) JSON.toJSON(data);
        }
    }

    private static JSONArray convertToJsonArray(Object data) {
        if (data == null) {
            return null;
        }
        if (data instanceof JSONArray) {
            return (JSONArray)data;
        } if (data instanceof String) {
            return JSONArray.parseArray((String)data);
        } else {
            return (JSONArray)JSON.toJSON(data);
        }
    }
}
