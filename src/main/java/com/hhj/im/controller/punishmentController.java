package com.hhj.im.controller;

import com.hhj.im.entity.s_punishment;
import com.hhj.im.entity.s_reward;
import com.hhj.im.service.punishmentService;
import com.hhj.im.util.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

    //获取学生惩罚信息
    @RequestMapping(value = "/findPunishmentList",method = RequestMethod.POST)
    public void findPunishmentList(HttpServletRequest request, HttpServletResponse response,@RequestBody Map<String,String> data) throws Exception{
        String pageIndex=data.get("pageNum");//页面索引，0：第一页，1：第二页，依次类推
        String pageSize=data.get("pageSize");//每页多少条
        String student_name=data.get("name");//搜索功能：获取搜索参数值（用户姓名）
        String student_id = data.get("id");

        HashMap mapParam=new HashMap();
        mapParam.put("pageSize", Integer.parseInt(pageSize));
        mapParam.put("rowNum", Integer.parseInt(pageSize)*(Integer.parseInt(pageIndex)-1));
        mapParam.put("student_name", student_name);
        mapParam.put("student_id",student_id);


        List<s_punishment> punishmentList = punishmentService.findPunishmentList(mapParam);
        int count=punishmentService.findPunishmentCount(mapParam);//查询数据总数，用于分页

        HashMap map=new HashMap();
        map.put("total", count);
        map.put("data", punishmentList);

        String json = JSON.encode(map);
        System.out.println(json);//数据测试
        //向前端返回数据
        response.getWriter().write(json);
    }

    //添加惩罚信息
    @RequestMapping(value = "/addPunishment",method = RequestMethod.POST)
    public void addPunishment(HttpServletRequest request, HttpServletResponse response,@RequestBody Map<String,String> data) throws Exception{
        String student_id = data.get("id");
        String levels = data.get("levels");
        String ratify = "T";
        String description = data.get("description");
        Integer level = punishmentService.getPCode(levels);

        s_punishment s_punishment = new s_punishment();
        s_punishment.setStudent_id(Long.parseLong(student_id));
        s_punishment.setLevels(level);
        s_punishment.setRatify(ratify);
        s_punishment.setDescription(description);

        int result = punishmentService.addPunishment(s_punishment);
        response.getWriter().write(JSON.encode(result));
    }

    //删除惩罚信息
    @RequestMapping(value = "/deletePunishment",method = RequestMethod.DELETE)
    public void deletePunishment(HttpServletRequest request, HttpServletResponse response,@RequestBody Map<String,Long[]> data) throws Exception{
        Long[] punishmen_id = data.get("ids");
        String punishment_ids = "";
        for (int i =0;i<punishmen_id.length;i++){
            if (i==punishmen_id.length-1){
                punishment_ids=punishment_ids+punishmen_id[i];
            } else {
                punishment_ids=punishment_ids+punishmen_id[i]+",";
            }
        }
        int result = punishmentService.deletePunishment(punishment_ids);
        response.getWriter().write(JSON.encode(result));
    }

    //获取惩罚信息
    @RequestMapping(value = "/findPunishment",method = RequestMethod.POST)
    public void findPunishment(HttpServletRequest request, HttpServletResponse response,@RequestBody Map<String,String> data) throws Exception{

    }

    //将惩罚置无效
    @RequestMapping(value="/setPunishmentTF",method = RequestMethod.POST)
    public void setPunishmentTF(HttpServletRequest request, HttpServletResponse response,@RequestBody Map<String,String> data)throws Exception{
        String punishment_id = data.get("id");
        String ratify = data.get("ratify");
        s_punishment s_punishment = new s_punishment();
        s_punishment.setPunishment_id(Long.parseLong(punishment_id));
        s_punishment.setRatify(ratify);

        int result = punishmentService.setPunishmentTF(s_punishment);
        response.getWriter().write(JSON.encode(result));
    }
}
