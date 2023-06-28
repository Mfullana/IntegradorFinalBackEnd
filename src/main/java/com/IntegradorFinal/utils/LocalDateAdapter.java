package com.IntegradorFinal.utils;

import com.google.gson.*;
import java.lang.reflect.Type;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.util.Locale;


public class LocalDateAdapter implements JsonSerializer<LocalDate>, JsonDeserializer<LocalDate> {

private static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @Override
    public JsonElement serialize(LocalDate localDate, Type srcType, JsonSerializationContext context){
    return new JsonPrimitive(dateFormatter.format(localDate));
}

    @Override
    public LocalDate deserialize(JsonElement json, Type typeOff, JsonDeserializationContext context)
            throws JsonParseException{
                return LocalDate.parse(json.getAsString(),
                        DateTimeFormatter.ofPattern("yyyy-MM-dd").withLocale(Locale.ENGLISH));
    }
}