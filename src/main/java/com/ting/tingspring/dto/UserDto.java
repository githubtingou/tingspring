package com.ting.tingspring.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 用户dto
 *
 * @author LISHUANG
 * @date 2019/10/22
 */
@Getter
@Setter
@ToString
public class UserDto {
    private Long id;
    private String name;
    private Integer age;
}
