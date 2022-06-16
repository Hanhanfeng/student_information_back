package com.hhj.im.controller;

import com.hhj.im.entity.s_punishment;
import com.hhj.im.service.punishmentService;
import com.hhj.im.util.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin("*")
@Controller
public class punishmentController {
    @Autowired
    private punishmentService punishmentService;

    @RequestMapping("/findPunishmentList")
    public void findPunishmentList(HttpServletRequest request, HttpServletResponse response,@RequestBody Map<String,String> data) throws Exception{
        String pageIndex=data.get("pageNum");//页面索引，0：第一页，1：第二页，依次类推
        String pageSize=data.get("pageSize");//每页多少条
        String student_name=data.get("name");//搜索功能：获取搜索参数值（用户姓名）

        HashMap mapParam=new HashMap();
        mapParam.put("pageSize", Integer.parseInt(pageSize));
        mapParam.put("rowNum", Integer.parseInt(pageSize)*(Integer.parseInt(pageIndex)-1));
        mapParam.put("student_name", student_name);


        List<s_punishment> punishmentList = punishmentService.findPunishmentList(mapParam);
        int count=punishmentService.findPunishmentCount(student_name);//查询数据总数，用于分页

        HashMap map=new HashMap();
        map.put("total", count);
        map.put("data", punishmentList);

        String json = JSON.encode(map);
        System.out.println(json);//数据测试
        //向前端返回数据
        response.getWriter().write(json);
    }
    @RequestMapping("/addPunishment")
    public void addPunishment(HttpServletRequest request, HttpServletResponse response,@RequestBody Map<String,String> data) throws Exception{

    }
    @RequestMapping("/deletePunishment")
    public void deletePunishment(HttpServletRequest request, HttpServletResponse response,@RequestBody Map<String,String> data) throws Exception{

    }
    @RequestMapping("/findPunishment")
    public void findPunishment(HttpServletRequest request, HttpServletResponse response,@RequestBody Map<String,String> data) throws Exception{

    }



}
