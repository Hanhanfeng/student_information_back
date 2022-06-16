package com.hhj.im.entity;

public class s_change_codes {
    private Integer c_code;
    private String c_description;

    public Integer getC_code() {
        return c_code;
    }

    public void setC_code(Integer c_code) {
        this.c_code = c_code;
    }

    public String getC_description() {
        return c_description;
    }

    public void setC_description(String c_description) {
        this.c_description = c_description;
    }

    @Override
    public String toString() {
        return "change_code{" +
                "c_code=" + c_code +
                ", c_description='" + c_description + '\'' +
                '}';
    }
}
