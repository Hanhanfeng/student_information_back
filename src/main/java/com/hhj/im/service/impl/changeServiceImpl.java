package com.hhj.im.service.impl;

import com.hhj.im.entity.s_change;
import com.hhj.im.mapper.changeMapper;
import com.hhj.im.service.changeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class changeServiceImpl implements changeService {

    @Resource
    private changeMapper changeMapper;

    @Override
    public List<s_change> findChangeList(Map map) {
        return changeMapper.findChangeList(map);
    }

    @Override
    public int findChangeCount(Map map) {
        return changeMapper.findChangeCount(map);
    }

    @Override
    public int addChange(s_change s_change) {
        return changeMapper.addChange(s_change);
    }

    @Override
    public int deleteChange(String change_ids) {
        return changeMapper.deleteChange(change_ids);
    }

    @Override
    public s_change findChange(Long change_id) {
        return changeMapper.findChange(change_id);
    }

    @Override
    public Integer getCCode(String changeDes) {
        return changeMapper.getCCode(changeDes);
    }
}
