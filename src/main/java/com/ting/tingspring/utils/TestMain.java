package com.ting.tingspring.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ting.tingspring.dto.UserDto;
import lombok.extern.slf4j.Slf4j;

/**
 * 测试
 *
 * @author LISHUANG
 * @date 2019/11/18
 */
@Slf4j
public class TestMain implements Test2, Test1, Test3 {


    public static void main(String[] args) {
        TestMain testMain = new TestMain();
        testMain.name("on");
//        System.out.println(testMain.a);
        UserDto userDto = new UserDto();
        userDto.setName("");
        userDto.setId(123456L);
        userDto.setEmail("148@qq.com");
        userDto.setAge(null);
        new Gson().toJson(userDto);
        System.out.println();
        GsonBuilder gsonbuilder = new GsonBuilder();
//        gsonbuilder.serializeNulls();
        Gson gson = gsonbuilder.create();
        System.out.println(gson.toJson(userDto));

        Gson myGson = new GsonBuilder()
                // 进行注册自己的 TypeAdapter
                .registerTypeAdapter(String.class, TypeAdaptersRedefine.STRING)
                .registerTypeAdapter(Integer.class, TypeAdaptersRedefine.INTEGER)
                .registerTypeAdapter(Double.class, TypeAdaptersRedefine.DOUBLE)
                .create();
        System.out.println(myGson.toJson(userDto));


        Gson gson2 = new GsonBuilder()// 进行注册自定义的适配器工厂
                .registerTypeAdapterFactory(new NullIntegerToEmptyAdapterFactory())
                .create();
        //序列化
        String json = gson2.toJson(userDto);
        System.out.println(json);
        //反序列化

        //json = gson2.fromJson(json, UserDto.class);

        System.out.println(json);
        JSON.toJSONString(userDto, SerializerFeature.WriteMapNullValue);
//


    }


    @Override
    public void name(String age) {

    }

    @Override
    public void name2(String naem) {

    }

    @Override
    public void name1(String naem) {

    }
}
