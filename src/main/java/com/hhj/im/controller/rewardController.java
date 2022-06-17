package com.hhj.im.controller;

import com.hhj.im.entity.s_reward;
import com.hhj.im.service.rewardService;
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
public class rewardController {
    @Autowired
    private rewardService rewardService;

    //获取奖励信息
    @RequestMapping(value = "/findRewardList",method = RequestMethod.POST)
    public void findRewardList(HttpServletRequest request, HttpServletResponse response,@RequestBody Map<String,String> data) throws Exception{
        String pageIndex=data.get("pageNum");//页面索引，0：第一页，1：第二页，依次类推
        String pageSize=data.get("pageSize");//每页多少条
        String student_name=data.get("name");//搜索功能：获取搜索参数值（用户姓名）
        String student_id = data.get("id");

        HashMap mapParam=new HashMap();
        mapParam.put("pageSize", Integer.parseInt(pageSize));
        mapParam.put("rowNum", Integer.parseInt(pageSize)*(Integer.parseInt(pageIndex)-1));
        mapParam.put("student_name", student_name);
        mapParam.put("student_id",student_id);


        List<s_reward> rewardList = rewardService.findRewardList(mapParam);
        int count=rewardService.findRewardCount(mapParam);//查询数据总数，用于分页

        HashMap map=new HashMap();
        map.put("total", count);
        map.put("data", rewardList);

        String json = JSON.encode(map);
        System.out.println(json);//数据测试
        //向前端返回数据
        response.getWriter().write(json);
    }


    @RequestMapping(value = "/addReward",method = RequestMethod.POST)
    public void addReward(HttpServletRequest request, HttpServletResponse response,@RequestBody Map<String,String> data) throws Exception{

    }
    @RequestMapping(value = "/deleteReward",method = RequestMethod.POST)
    public void deleteReward(HttpServletRequest request, HttpServletResponse response,@RequestBody Map<String,String> data) throws Exception{

    }
    @RequestMapping(value = "/findReward",method = RequestMethod.POST)
    public void findReward(HttpServletRequest request, HttpServletResponse response,@RequestBody Map<String,String> data) throws Exception{

    }



}
