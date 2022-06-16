package com.hhj.im.entity;

public class s_reward_codes {
    private Integer r_code;
    private String r_description;

    public Integer getR_code() {
        return r_code;
    }

    public void setR_code(Integer r_code) {
        this.r_code = r_code;
    }

    public String getR_description() {
        return r_description;
    }

    public void setR_description(String r_description) {
        this.r_description = r_description;
    }

    @Override
    public String toString() {
        return "reward_levels{" +
                "r_code=" + r_code +
                ", r_description='" + r_description + '\'' +
                '}';
    }
}
