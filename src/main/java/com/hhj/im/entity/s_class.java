package com.hhj.im.entity;

public class s_class {
    private Long class_id;
    private String class_name;
    private Long monitor;
    private Integer dept;

    public Long getClass_id() {
        return class_id;
    }

    public void setClass_id(Long class_id) {
        this.class_id = class_id;
    }

    public String getClass_name() {
        return class_name;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }

    public Long getMonitor() {
        return monitor;
    }

    public void setMonitor(Long monitor) {
        this.monitor = monitor;
    }

    public Integer getDept() {
        return dept;
    }

    public void setDept(Integer dept) {
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "classes{" +
                "class_id=" + class_id +
                ", class_name='" + class_name + '\'' +
                ", monitor=" + monitor +
                ", dept=" + dept +
                '}';
    }
}
