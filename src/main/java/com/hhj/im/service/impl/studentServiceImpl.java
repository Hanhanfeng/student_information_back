package com.hhj.im.service.impl;

import com.github.pagehelper.PageHelper;
import com.hhj.im.entity.student;
import com.hhj.im.mapper.studentMapper;
import com.hhj.im.service.studentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class studentServiceImpl implements studentService {
    @Resource
    private studentMapper studentMapper;

    @Override
    public List<student> findStudentList(Map map) {
        return studentMapper.findStudentList(map);
    }


    /*@Override
    public List<student> findStudentList(Map map,int pageIndex, int pageSize) {
        PageHelper.startPage(pageIndex,pageSize);
        return studentMapper.findStudentList(map);
    }*/

    @Override
    public int findStudentCount(Map map) {
        return studentMapper.findStudentCount(map);
    }

    @Override
    public Integer addStudent(student student) {
        return studentMapper.addStudent(student);
    }

    @Override
    public Integer deleteStudent(String student_ids) {
        return studentMapper.deleteStudent(student_ids);
    }

    @Override
    public student findStudent(Long student_id) {
        return studentMapper.findStudent(student_id);
    }

    @Override
    public Integer updateStudent(student student) {
        return studentMapper.updateStudent(student);
    }
}
