package com.hhj.im.entity;

public class s_dept {
    private Long dept_id;
    private String dept_name;

    public Long getDept_id() {
        return dept_id;
    }

    public void setDept_id(Long dept_id) {
        this.dept_id = dept_id;
    }

    public String getDept_name() {
        return dept_name;
    }

    public void setDept_name(String dept_name) {
        this.dept_name = dept_name;
    }

    @Override
    public String toString() {
        return "dept{" +
                "dept_id=" + dept_id +
                ", dept_name='" + dept_name + '\'' +
                '}';
    }
}
