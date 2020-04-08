package com.pg.bbs.service.impl;

import com.pg.bbs.dao.RecommendMapper;
import com.pg.bbs.entity.Recommend;
import com.pg.bbs.service.RecommendService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.UUID;

@Service
public class RecommendServiceImpl implements RecommendService {

    @Resource
    private RecommendMapper recommendMapper;

    @Override
    public int insert(Recommend recommend) {
        recommend.setUuid(UUID.randomUUID().toString().replace("-", ""));
        recommend.setVotes(0);
        recommend.setViewsWord(0);
        recommend.setCreateTime(new Date());
        recommend.setModifyTime(new Date());
        return recommendMapper.insert(recommend);
    }

    @Override
    public int update(Recommend recommend) {
        return 0;
    }
}
