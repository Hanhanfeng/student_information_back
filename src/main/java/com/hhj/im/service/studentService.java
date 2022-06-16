package com.hhj.im.service;

import com.hhj.im.entity.student;

import java.util.List;
import java.util.Map;

public interface studentService {
    List<student> findStudentList(Map map);

    /*List<student> findStudentList(Map map,int pageIndex,int pageSize);*/

    int findStudentCount(Map map);

    Integer addStudent(student student);

    Integer deleteStudent(String student_ids);

    student findStudent(Long student_id);


    Integer updateStudent(student student);
}
