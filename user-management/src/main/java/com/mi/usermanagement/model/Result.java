package com.mi.usermanagement.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> {
    private Integer code;  // 状态码 0-success 1-fail
    private String message;  // 响应消息
    private T data;  // 响应数据

    public static <T> Result<T> success(String message, T data) {
        return new Result<>(0, message, data);
    }

    public static Result success(String message) {
        return new Result<>(0, message, null);
    }

    public static Result error(String message) {
        return new Result<>(1, message, null);
    }

    public static<T> Result<T> error(String message, T data) {
        return new Result<>(1, message, data);
    }
}
