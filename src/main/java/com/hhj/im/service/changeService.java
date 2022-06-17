package com.hhj.im.service;

import com.hhj.im.entity.s_change;

import java.util.List;
import java.util.Map;

public interface changeService {
    List<s_change> findChangeList(Map map);

    int findChangeCount(Map map);

    int addChange(s_change change);

    int deleteChange(String change_ids);

    s_change findChange(Long change_id);


}
