package com.rainy.video;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * @author Jacky
 * @date 2024/12/6
 **/

public class ApiResponse<T> implements Serializable {
    public static final int STATUS_SUCCESS = 200;
    public static final int STATUS_FAILED = 0;

    private int status; // 状态码，200表示成功，0表示失败
    private String message; // 响应信息
    private T data; // 泛型数据内容

    // 构造函数，初始化默认值
    public ApiResponse() {
        this.status = STATUS_SUCCESS;
        this.message = "成功";
    }

    // 带参构造函数
    public ApiResponse(int status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    // 获取状态码U
    public int getStatus() {
        return status;
    }

    // 设置状态码
    public void setStatus(int status) {
        this.status = status;
    }

    // 获取响应消息
    public String getMessage() {
        return message;
    }

    // 设置响应消息
    public void setMessage(String message) {
        this.message = message;
    }

    // 获取数据内容
    @JsonProperty("data")
    public T getData() {
        return data;
    }

    // 设置数据内容
    public void setData(T data) {
        this.data = data;
    }

    // 设置响应结果（状态码、消息和数据）
    public void setResult(int status, String message, T data) {
        this.status = status;
        this.message = message != null ? message : (status == STATUS_SUCCESS ? "成功" : "失败");
        this.data = data;
    }


    // 设置成功响应结果
    public void setSuccessResult(T data) {
        this.status = STATUS_SUCCESS;
        this.message = "成功";
        this.data = data;
    }

    // 设置失败响应结果
    public void setFailedResult(String message) {
        this.status = STATUS_FAILED;
        this.message = message != null ? message : "失败";
        this.data = null;
    }

    @Override
    public String toString() {
        return "ApiResponse{" +
                "status=" + status +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
