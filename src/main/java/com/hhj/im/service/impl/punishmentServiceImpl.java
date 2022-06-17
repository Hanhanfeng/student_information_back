package com.hhj.im.service.impl;

import com.hhj.im.entity.s_punishment;
import com.hhj.im.mapper.punishmentMapper;
import com.hhj.im.service.punishmentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@Service
@Transactional
public class punishmentServiceImpl implements punishmentService {

    @Resource
    private punishmentMapper punishmentMapper;
    @Override
    public List<s_punishment> findPunishmentList(HashMap mapParam) {
        return punishmentMapper.findPunishmentList(mapParam);
    }

    @Override
    public int findPunishmentCount(String student_name) {
        return punishmentMapper.findPunishmentCount(student_name);
    }

    @Override
    public Integer deletePunishment(String punishment_ids) {
        return punishmentMapper.deletePunishment(punishment_ids);
    }
}
