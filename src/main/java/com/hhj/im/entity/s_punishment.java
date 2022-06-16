package com.hhj.im.entity;

import java.util.Date;

public class s_punishment {
    private Long punishment_id;
    private Long student_id;
    private Integer levels;
    private String ratify;
    private String description;
    private Date rec_time;
    private student student;
    private s_punishment_codes s_punishment_codes;

    public Long getPunishment_id() {
        return punishment_id;
    }

    public void setPunishment_id(Long punishment_id) {
        this.punishment_id = punishment_id;
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

    public String getRatify() {
        return ratify;
    }

    public void setRatify(String ratify) {
        this.ratify = ratify;
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

    public com.hhj.im.entity.s_punishment_codes getS_punishment_codes() {
        return s_punishment_codes;
    }

    public void setS_punishment_codes(com.hhj.im.entity.s_punishment_codes s_punishment_codes) {
        this.s_punishment_codes = s_punishment_codes;
    }

    @Override
    public String toString() {
        return "s_punishment{" +
                "punishment_id=" + punishment_id +
                ", student_id=" + student_id +
                ", levels=" + levels +
                ", enable='" + ratify + '\'' +
                ", description='" + description + '\'' +
                ", rec_time=" + rec_time +
                ", student=" + student +
                ", s_punishment_codes=" + s_punishment_codes +
                '}';
    }
}
