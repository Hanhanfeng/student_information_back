package com.hhj.im.mapper;

import com.hhj.im.entity.s_reward;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface rewardMapper {
    List<s_reward> findRewardList(Map map);

    int findRewardCount(Map map);
}
