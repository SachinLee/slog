package com.sachin.slog.utils;

import com.alibaba.fastjson.JSON;

public class JsonMapper {

    public static <T> String obj2String(T obj) {
        return JSON.toJSONString(obj);
    }

    public static <T> T string2Obj(String str, Class<T> clazz) {
        return JSON.parseObject(str, clazz);
    }

}
