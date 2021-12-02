package com.example.smartbudget.Model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.google.gson.JsonSyntaxException;

import java.io.Reader;
import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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