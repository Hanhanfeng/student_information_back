package com.hhj.im.controller;

import com.hhj.im.entity.s_change;
import com.hhj.im.entity.s_reward;
import com.hhj.im.service.changeService;
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
public class changeController {
    @Autowired
    private changeService changeService;
    //获取学籍异动列表
    @RequestMapping(value = "/findChangeList",method = RequestMethod.POST)
    public void findChangeList(HttpServletRequest request, HttpServletResponse response,@RequestBody Map<String,String> data) throws Exception{
        String pageIndex=data.get("pageNum");//页面索引，0：第一页，1：第二页，依次类推
        String pageSize=data.get("pageSize");//每页多少条
        String student_name=data.get("name");//搜索功能：获取搜索参数值（用户姓名）
        String student_id = data.get("id");

        HashMap mapParam=new HashMap();
        mapParam.put("pageSize", Integer.parseInt(pageSize));
        mapParam.put("rowNum", Integer.parseInt(pageSize)*(Integer.parseInt(pageIndex)-1));
        mapParam.put("student_name", student_name);
        mapParam.put("student_id",student_id);


        List<s_change> changeList = changeService.findChangeList(mapParam);
        int count=changeService.findChangeCount(mapParam);//查询数据总数，用于分页

        HashMap map=new HashMap();
        map.put("total", count);
        map.put("data", changeList);

        String json = JSON.encode(map);
        System.out.println(json);//数据测试
        //向前端返回数据
        response.getWriter().write(json);
    }

    //添加学籍异动情况
    @RequestMapping(value = "/addChange",method = RequestMethod.POST)
    public void addChange(HttpServletRequest request, HttpServletResponse response,@RequestBody Map<String,String> data) throws Exception{
        String student_id = data.get("id");
        String changeDes = data.get("type");
        String description = data.get("description");
        Integer change_code = changeService.getCCode(changeDes);

        s_change s_change = new s_change();
        s_change.setStudent_id(Long.parseLong(student_id));
        s_change.setChange_code(change_code);
        s_change.setDescription(description);

        int result = changeService.addChange(s_change);
        response.getWriter().write(JSON.encode(result));
    }

    //删除学籍异动记录
    @RequestMapping(value = "/deleteChange",method = RequestMethod.DELETE)
    public void deleteChange(HttpServletRequest request, HttpServletResponse response,@RequestBody Map<String,Long[]> data) throws Exception{
        Long[] change_id = data.get("ids");
        String change_ids = "";
        for (int i =0;i<change_id.length;i++){
            if (i==change_id.length-1){
                change_ids=change_ids+change_id[i];
            } else {
                change_ids=change_ids+change_id[i]+",";
            }
        }
        changeService.deleteChange(change_ids);
    }

    //通过id获取相应学籍异动记录
    @RequestMapping(value = "/findChange",method = RequestMethod.POST)
    public void findChange(HttpServletRequest request, HttpServletResponse response,@RequestBody Map<String,String> data) throws Exception{
        String change_id = data.get("id");
        s_change sChange = changeService.findChange(Long.parseLong(change_id));
        String json = JSON.encode(sChange);
        response.getWriter().write(json);
    }



}

