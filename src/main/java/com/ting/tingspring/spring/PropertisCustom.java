package com.ting.tingspring.spring;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;

/**
 * 自定义配置信息
 *
 * @author LISHUANG
 * @date 2019/10/24
 */
@Component
@ConfigurationProperties(prefix = "ting")
@Getter
@Setter
public class PropertisCustom {
    private String name;
    private Integer age;
    private HashMap<String, Object> hashMap;
    private List<String> list;
    private String email;
}
