package com.hhj.im.service;

import com.hhj.im.entity.s_reward;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface rewardService {
    List<s_reward> findRewardList(Map mapParam);

    int findRewardCount(Map map);

    Integer deleteReward(String reward_ids);

    Integer getRCode(String levels);

    int addReward(s_reward s_reward);
}
