package com.example.smartbudget.Model;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import java.io.Reader;

public class JsonHandler {
    public JsonHandler() {
    }

    public static Object Decode(String jsonStr, Object objClass) throws JsonSyntaxException {
        Gson gson = new Gson();
        objClass = gson.fromJson(jsonStr, objClass.getClass());
        return objClass;
    }

    public static Object Decode(Reader jsonReader, Object objClass) throws JsonSyntaxException {
        Gson gson = new Gson();
        objClass = gson.fromJson(jsonReader, objClass.getClass());
        return objClass;
    }

    public static String Encode(Object objToEncode) {
        Gson gson = new Gson();
        return gson.toJson(objToEncode);
    }
}
