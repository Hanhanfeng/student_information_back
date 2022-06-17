package com.hhj.im.service.impl;

import com.hhj.im.entity.s_reward;
import com.hhj.im.mapper.rewardMapper;
import com.hhj.im.service.rewardService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class rewardServiceImpl implements rewardService {

    @Resource
    private rewardMapper rewardMapper;
    @Override
    public List<s_reward> findRewardList(Map mapParam) {
        return rewardMapper.findRewardList(mapParam);
    }

    @Override
    public int findRewardCount(Map map) {
        return rewardMapper.findRewardCount(map);
    }
}
