package com.hhj.im.mapper;

import com.hhj.im.entity.s_punishment;

import java.util.HashMap;
import java.util.List;

public interface punishmentMapper {
    List<s_punishment> findPunishmentList(HashMap mapParam);

    int findPunishmentCount(String student_name);

    Integer deletePunishment(String punishment_ids);
}
