package com.qiqi.account.common;

/**
 * 一般响应
 */
public class CommonResponse {

    private static final CommonResponse ok = new CommonResponse().setStatus(0);

    protected int status;

    private String description;

    public static CommonResponse ok() {
        return ok;
    }

    public static CommonResponse error() {
        return new CommonResponse().setStatus(1);
    }

    public int getStatus() {
        return status;
    }

    public CommonResponse setStatus(int status) {
        this.status = status;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public CommonResponse setDescription(String description) {
        this.description = description;
        return this;
    }

    @Override
    public String toString() {
        return "CommonResponse{" +
                "status=" + status +
                ", description='" + description + '\'' +
                '}';
    }
}
