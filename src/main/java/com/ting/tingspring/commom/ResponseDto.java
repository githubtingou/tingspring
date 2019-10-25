package com.ting.tingspring.commom;

import lombok.*;

/**
 * 返参dto
 *
 * @author LISHUANG
 * @date 2019/10/24
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDto<T> {
    private Integer code;
    private String msg;
    private boolean success;
    private T data;

}
