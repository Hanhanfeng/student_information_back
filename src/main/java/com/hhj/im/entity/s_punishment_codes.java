package com.hhj.im.entity;

public class s_punishment_codes {
    private Integer p_code;
    private String p_description;

    public Integer getP_code() {
        return p_code;
    }

    public void setP_code(Integer p_code) {
        this.p_code = p_code;
    }

    public String getP_description() {
        return p_description;
    }

    public void setP_description(String p_description) {
        this.p_description = p_description;
    }

    @Override
    public String toString() {
        return "punishment_levels{" +
                "p_code=" + p_code +
                ", p_description='" + p_description + '\'' +
                '}';
    }
}
