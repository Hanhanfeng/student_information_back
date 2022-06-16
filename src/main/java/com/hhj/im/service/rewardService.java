package com.hhj.im.service;

import com.hhj.im.entity.s_reward;

import java.util.HashMap;
import java.util.List;

public interface rewardService {
    List<s_reward> findRewardList(HashMap mapParam);

    int findRewardCount(String student_name);
}
