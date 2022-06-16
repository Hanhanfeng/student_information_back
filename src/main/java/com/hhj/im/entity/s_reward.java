package com.hhj.im.entity;

import java.util.Date;

public class s_reward {
    private Long reward_id;
    private Long student_id;
    private Integer levels;
    private String description;
    private Date rec_time;
    private student student;
    private s_reward_codes s_reward_codes;

    public Long getReward_id() {
        return reward_id;
    }

    public void setReward_id(Long reward_id) {
        this.reward_id = reward_id;
    }

    public Long getStudent_id() {
        return student_id;
    }

    public void setStudent_id(Long student_id) {
        this.student_id = student_id;
    }

    public Integer getLevels() {
        return levels;
    }

    public void setLevels(Integer levels) {
        this.levels = levels;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getRec_time() {
        return rec_time;
    }

    public void setRec_time(Date rec_time) {
        this.rec_time = rec_time;
    }

    public com.hhj.im.entity.student getStudent() {
        return student;
    }

    public void setStudent(com.hhj.im.entity.student student) {
        this.student = student;
    }

    public s_reward_codes getS_reward_codes() {
        return s_reward_codes;
    }

    public void setS_reward_codes(s_reward_codes s_reward_codes) {
        this.s_reward_codes = s_reward_codes;
    }

    @Override
    public String toString() {
        return "s_reward{" +
                "reward_id=" + reward_id +
                ", student_id=" + student_id +
                ", levels=" + levels +
                ", description='" + description + '\'' +
                ", rec_time=" + rec_time +
                ", student=" + student +
                ", s_reward_codes=" + s_reward_codes +
                '}';
    }
}
