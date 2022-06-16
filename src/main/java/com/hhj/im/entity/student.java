package com.hhj.im.entity;

import java.util.Date;

public class student {
    private Long student_id;
    private String student_name;
    private String sex;
    private Long class_id;
    private Long dept;
    private Date birthday;
    private String native_place;
    private s_class s_class;
    private s_dept s_dept;

    public Long getStudent_id() {
        return student_id;
    }

    public void setStudent_id(Long student_id) {
        this.student_id = student_id;
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Long getClass_id() {
        return class_id;
    }

    public void setClass_id(Long class_id) {
        this.class_id = class_id;
    }

    public Long getDept() {
        return dept;
    }

    public void setDept(Long dept) {
        this.dept = dept;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getNative_place() {
        return native_place;
    }

    public void setNative_place(String native_place) {
        this.native_place = native_place;
    }

    public s_class getS_class() {
        return s_class;
    }

    public void setS_class(s_class s_class) {
        this.s_class = s_class;
    }

    public s_dept getS_dept() {
        return s_dept;
    }

    public void setS_dept(s_dept s_dept) {
        this.s_dept = s_dept;
    }

    @Override
    public String toString() {
        return "student{" +
                "student_id=" + student_id +
                ", student_name='" + student_name + '\'' +
                ", sex='" + sex + '\'' +
                ", class_id=" + class_id +
                ", dept=" + dept +
                ", birthday=" + birthday +
                ", native_place='" + native_place + '\'' +
                ", classes=" + s_class +
                ", depts=" + s_dept +
                '}';
    }
}
