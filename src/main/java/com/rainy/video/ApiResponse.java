package com.rainy.video;


import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

/**
 * @author Jacky
 * @date 2024/12/6
 **/

@JsonIgnoreProperties({"responseBody"})
public class ApiResponse<T> implements Serializable {
    public static final int STATUS_SUCCESS = 200;
    public static final int STATUS_FAILED = 0;

    private int status = STATUS_SUCCESS;
    private String message = "成功";
    private JSONObject data = new JSONObject();

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public JSONObject getData() {
        return data;
    }

    public T getResponseBody() {
        return data.getObject("data", new TypeReference<T>() {
        }.getType());
    }

    public void setData(String objectKey, T data) {
        JSONObject body = new JSONObject();
        body.put(objectKey, data);
        this.data.put("data", body);
    }

    public void setData(T data) {
        this.data.put("data", data);
    }

    public void setResult(int status, String message) {
        setStatus(status);
        setMessage(message);
    }

    public void setResult(int status, String message, T data) {
        String msg = status == STATUS_SUCCESS && message == null ? "成功" : message;
        setStatus(status);
        setMessage(msg);
        setData(data);
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
