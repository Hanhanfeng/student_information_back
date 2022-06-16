package com.hhj.im.controller;

import com.hhj.im.entity.s_change;
import com.hhj.im.service.changeService;
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
public class changeController {
    @Autowired
    private changeService changeService;

    @RequestMapping("/findChangeList")
    public void findChangeList(HttpServletRequest request, HttpServletResponse response,@RequestBody Map<String,String> data) throws Exception{
        String pageIndex=data.get("pageNum");//页面索引，0：第一页，1：第二页，依次类推
        String pageSize=data.get("pageSize");//每页多少条
        String student_name=data.get("name");//搜索功能：获取搜索参数值（用户姓名）

        HashMap mapParam=new HashMap();
        mapParam.put("pageSize", Integer.parseInt(pageSize));
        mapParam.put("rowNum", Integer.parseInt(pageSize)*(Integer.parseInt(pageIndex)-1));
        mapParam.put("student_name", student_name);


        List<s_change> changeList = changeService.findChangeList(mapParam);
        int count=changeService.findChangeCount(student_name);//查询数据总数，用于分页

        HashMap map=new HashMap();
        map.put("total", count);
        map.put("data", changeList);

        String json = JSON.encode(map);
        System.out.println(json);//数据测试
        //向前端返回数据
        response.getWriter().write(json);
    }
    @RequestMapping("/addChange")
    public void addChange(HttpServletRequest request, HttpServletResponse response,@RequestBody Map<String,String> data) throws Exception{

    }
    @RequestMapping("/deleteChange")
    public void deleteChange(HttpServletRequest request, HttpServletResponse response,@RequestBody Map<String,String> data) throws Exception{

    }
    @RequestMapping("/findChange")
    public void findChange(HttpServletRequest request, HttpServletResponse response,@RequestBody Map<String,String> data) throws Exception{

    }



}

