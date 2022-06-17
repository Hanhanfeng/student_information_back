package com.hhj.im.mapper;

import com.hhj.im.entity.s_class;
import com.hhj.im.entity.s_dept;
import com.hhj.im.entity.student;

import java.util.List;
import java.util.Map;

public interface studentMapper {
//    List<student> findStudentList(Map map);

    List<student> findStudentList(Map map);
    int findStudentCount(Map map);

    Integer addStudent(student student);

    Integer deleteStudent(String student_ids);

    student findStudent(Long student_id);

    Integer updateStudent(student student);

    Long getClassId(String class_name);

    Long getDeptId(String dept_name);

    List<s_dept> getDept();

    List<s_class> getClassByDept(long dept);
}
