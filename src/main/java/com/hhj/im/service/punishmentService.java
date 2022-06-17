package com.hhj.im.service;

import com.hhj.im.entity.s_punishment;

import java.util.HashMap;
import java.util.List;

public interface punishmentService {
    List<s_punishment> findPunishmentList(HashMap mapParam);

    int findPunishmentCount(String student_name);

    Integer deletePunishment(String punishment_ids);
}
