package com.hhj.im.mapper;

import com.hhj.im.entity.s_change;

import java.util.List;
import java.util.Map;

public interface changeMapper {
    List<s_change> findChangeList(Map map);

    int findChangeCount(Map map);

    int addChange(s_change change);

    int deleteChange(String change_id);

    s_change findChange(Long change_id);
}
