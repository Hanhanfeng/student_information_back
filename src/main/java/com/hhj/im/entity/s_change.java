package com.hhj.im.entity;

import java.util.Date;

public class s_change {
    private Long change_id;
    private Long student_id;
    private Integer change_code;
    private String description;
    private Date rec_time;
    private student student;
    private s_change_codes s_change_codes;

    public Long getChange_id() {
        return change_id;
    }

    public void setChange_id(Long change_id) {
        this.change_id = change_id;
    }

    public Long getStudent_id() {
        return student_id;
    }

    public void setStudent_id(Long student_id) {
        this.student_id = student_id;
    }

    public Integer getChange_code() {
        return change_code;
    }

    public void setChange_code(Integer change_code) {
        this.change_code = change_code;
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

    public com.hhj.im.entity.student getStudent() {
        return student;
    }

    public void setStudent(com.hhj.im.entity.student student) {
        this.student = student;
    }

    public void setRec_time(Date rec_time) {
        this.rec_time = rec_time;
    }

    public s_change_codes getS_change_codes() {
        return s_change_codes;
    }

    public void setS_change_codes(s_change_codes s_change_codes) {
        this.s_change_codes = s_change_codes;
    }

    @Override
    public String toString() {
        return "s_change{" +
                "change_id=" + change_id +
                ", student_id=" + student_id +
                ", change_code=" + change_code +
                ", description='" + description + '\'' +
                ", rec_time=" + rec_time +
                ", student=" + student +
                ", s_change_codes=" + s_change_codes +
                '}';
    }
}
