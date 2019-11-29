package com.ting.tingspring.utils;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

public class StringNullAdapter extends TypeAdapter<String> {
    /**
     * 反序列化时 若为 null 或 空字符串
   *    皆反序列化 为 null
     * @param reader
     * @return
     * @throws IOException
     */
    @Override
    public String read(JsonReader reader) throws IOException {

        if (reader.peek() == JsonToken.NULL) {
            reader.nextNull();
            return null;
        }
        String res = reader.nextString();
        return "".equals(res) ? null : res;
    }

    /**
     * 序列化时  若属性值 为null  则 序列化为 空字符串
   * 反之  反序列化时 若属性值 为 null 或者为 空字符串时  --
     *    则对应反序列化为 null
     * @param writer
     * @param value
     * @throws IOException
     */
    @Override
    public void write(JsonWriter writer, String value) throws IOException {
        if (value == null) {
            writer.value("");
            return;
        }
        writer.value(value);
    }
}
