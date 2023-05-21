package com.tuleaj.domain;

public class Response {
    private String token;
    private int code;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "Response{" +
                "token='" + token + '\'' +
                ", code=" + code +
                '}';
    }
}
