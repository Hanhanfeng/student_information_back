package com.hhj.im.mapper;

import com.hhj.im.entity.s_punishment;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface punishmentMapper {
    List<s_punishment> findPunishmentList(HashMap mapParam);

    int findPunishmentCount(Map map);

    Integer deletePunishment(String punishment_ids);

    Integer getPCode(String levels);

    Integer addPunishment(s_punishment s_punishment);

    Integer setPunishmentTF(s_punishment s_punishment);
}
