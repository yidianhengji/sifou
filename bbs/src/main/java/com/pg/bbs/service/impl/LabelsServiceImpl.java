package com.pg.bbs.service.impl;

import com.github.pagehelper.util.StringUtil;
import com.pg.bbs.dao.LabelsMapper;
import com.pg.bbs.entity.Labels;
import com.pg.bbs.handler.BusinessException;
import com.pg.bbs.service.LabelsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class LabelsServiceImpl implements LabelsService {

    @Resource
    private LabelsMapper labelsMapper;

    @Override
    public List<Labels> queryOne(String uuid) {
        if (StringUtil.isEmpty(uuid)) {
            throw new BusinessException(500, "uuid必传");
        }
        return labelsMapper.queryOne(uuid);
    }

    @Override
    public int insert(Labels labels) {
        labels.setUuid(UUID.randomUUID().toString().replace("-", ""));
        labels.setCreateTime(new Date());
        labels.setModifyTime(new Date());
        return labelsMapper.insert(labels);
    }

    @Override
    public int update(Labels labels) {
        if (StringUtil.isEmpty(labels.getUuid())) {
            throw new BusinessException(500, "uuid必传");
        }
        labels.setModifyTime(new Date());
        return labelsMapper.update(labels);
    }

    @Override
    public int delete(String uuid) {
        if (StringUtil.isEmpty(uuid)) {
            throw new BusinessException(500, "uuid必传");
        }
        return labelsMapper.delete(uuid);
    }
}
