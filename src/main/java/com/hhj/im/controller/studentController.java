package com.hhj.im.controller;

import com.github.pagehelper.PageInfo;
import com.hhj.im.entity.s_class;
import com.hhj.im.entity.s_dept;
import com.hhj.im.entity.student;
import com.hhj.im.service.studentService;
import com.hhj.im.util.JSON;
import com.hhj.im.util.Page;
import com.hhj.im.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

@CrossOrigin("*")
@Controller
public class studentController {
    @Autowired
    private studentService studentService;

    //获取学生信息列表，可传入分页信息和搜索信息（name，id）
    @RequestMapping(value = "/findStudentList",method = RequestMethod.POST)
    public void findStudentList(HttpServletRequest request,HttpServletResponse response,@RequestBody Map<String,String>data) throws Exception{
        String pageIndex=data.get("pageNum");//页面索引，0：第一页，1：第二页，依次类推
        String pageSize=data.get("pageSize");//每页多少条
        String student_name=data.get("name");//搜索功能：获取搜索参数值（用户姓名）
        String student_id=data.get("id");

        HashMap mapParam=new HashMap();
        mapParam.put("pageSize", Integer.parseInt(pageSize));
        mapParam.put("rowNum", Integer.parseInt(pageSize)*(Integer.parseInt(pageIndex)-1));
        mapParam.put("student_name", student_name);
        mapParam.put("student_id",student_id);

        List<student> studentList = studentService.findStudentList(mapParam);
        int count=studentService.findStudentCount(mapParam);//查询数据总数，用于分页

        HashMap map=new HashMap();
        map.put("total", count);
        map.put("data", studentList);

        String json = JSON.encode(map);
        System.out.println(json);//数据测试
        //向前端返回数据
        response.getWriter().write(json);
    }

    /*@RequestMapping("/findStudentList")
    public void findStudentList(HttpServletRequest request, HttpServletResponse response) throws Exception{
        String pageIndex=request.getParameter("pageIndex");//页面索引，0：第一页，1：第二页，依次类推
        String pageSize=request.getParameter("pageSize");//每页多少条
        String student_name=request.getParameter("key");//搜索功能：获取搜索参数值（用户姓名）
        String student_id =request.getParameter("id");

        HashMap mapParam=new HashMap();;
        mapParam.put("student_name", student_name);
        mapParam.put("student_id",student_id);

        List<student> studentList = studentService.findStudentList(mapParam,Integer.parseInt(pageIndex),Integer.parseInt(pageSize));
        PageInfo<student> info = new PageInfo<>(studentList);
        System.out.println(JSON.encode(info));//数据测试
        //向前端返回数据
        response.getWriter().write(JSON.encode(info));
    }*/

    //添加学生信息
    @RequestMapping(value = "/addStudent",method = RequestMethod.POST)
    public void addStudent(HttpServletRequest request, HttpServletResponse response,@RequestBody Map<String,String>data) throws Exception{
        String student_id = data.get("id");
        String student_name = data.get("name");
        String sex = data.get("sex");
        String class_id = data.get("classId");
        String dept = data.get("dept");
        String birthday = data.get("birthday");
        String native_place = data.get("place");

        student student = new student();
        student.setStudent_id(Long.parseLong(student_id));
        student.setStudent_name(student_name);
        student.setSex(sex);
        student.setDept(Long.parseLong(dept));
        student.setClass_id(Long.parseLong(class_id));
        student.setNative_place(native_place);
        student.setBirthday(new SimpleDateFormat("yyyy-MM-dd", Locale.US).parse(birthday));
        student student0 = studentService.findStudent(Long.parseLong(student_id));
        if(student0==null){
            studentService.addStudent(student);
            response.getWriter().write(JSON.encode(1));
        } else {
            response.getWriter().write(JSON.encode(0));
        }
    }

    //接收学生学号删除信息
    @RequestMapping(value = "/deleteStudent",method = RequestMethod.DELETE)
    public void deleteStudent(HttpServletRequest request, HttpServletResponse response,@RequestBody Map<String, Long[]>data) throws Exception{
        Long[] student_id = data.get("ids");
        String student_ids = "";
        for (int i =0;i<student_id.length;i++){
            if (i==student_id.length-1){
                student_ids=student_ids+student_id[i];
            } else {
                student_ids=student_ids+student_id[i]+",";
            }
        }
        int result = studentService.deleteStudent(student_ids);
        response.getWriter().write(JSON.encode(result));
    }

    //通过id获取学生信息
    @RequestMapping("/findStudent")
    public void findStudent(HttpServletRequest request, HttpServletResponse response,@RequestBody Map<String,String>data) throws Exception{
        String student_id = data.get("id");
        student student = studentService.findStudent(Long.parseLong(student_id));
        String json = JSON.encode(student);
        response.getWriter().write(json);
    }

    //修改学生信息
    @RequestMapping(value = "/updateStudent",method = RequestMethod.POST)
    public void updateStudent(HttpServletRequest request, HttpServletResponse response,@RequestBody Map<String,String>data) throws Exception{
        String student_id = data.get("id");
        String student_name = data.get("name");
        String sex = data.get("sex");
        String class_id = data.get("classId");
        String dept = data.get("dept");
        String birthday = data.get("birthday");
        String native_place = data.get("place");

        student student = new student();
        student.setStudent_id(Long.parseLong(student_id));
        student.setStudent_name(student_name);
        student.setSex(sex);
        student.setDept(Long.parseLong(dept));
        student.setClass_id(Long.parseLong(class_id));
        student.setNative_place(native_place);
        student.setBirthday(new SimpleDateFormat("yyyy-MM-dd", Locale.US).parse(birthday));

        int result = studentService.updateStudent(student);
        response.getWriter().write(JSON.encode(result));

    }

    //获取所有院系
    @RequestMapping("getDept")
    public void getDept(HttpServletRequest request, HttpServletResponse response,@RequestBody Map<String,String>data) throws Exception{
        List<s_dept> deptList = studentService.getDept();
        String json = JSON.encode(deptList);
        response.getWriter().write(json);
    }

    //通过院系id获取院系班级
    @RequestMapping("getClassByDept")
    public void getClassById(HttpServletRequest request, HttpServletResponse response,@RequestBody Map<String,String>data) throws Exception{
        String dept = data.get("dept");
        String name = data.get("deptName");
        Long dept0;

        if (name!=null && name!=""){
            dept0 = studentService.getDeptId(name);
        } else {
            dept0=Long.parseLong(dept);
        }

        List<s_class> classList = studentService.getClassByDept(dept0);
        String json = JSON.encode(classList);
        response.getWriter().write(json);
    }




}
