package com.ting.tingspring.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;

/**
 * 用户dto
 *
 * @author LISHUANG
 * @date 2019/10/22
 */
@Getter
@Setter
@ToString
@Validated
public class UserDto {
    private Long id;
    @Max(value = 3, message = "名称长度不能超过3")
    private String name;
    private Integer age = 16;
    @Email(message = "不符合邮箱格式")
    private String email;

}
