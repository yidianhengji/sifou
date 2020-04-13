package com.pg.bbs.service.impl;

import com.github.pagehelper.util.StringUtil;
import com.pg.bbs.dao.RecommendMapper;
import com.pg.bbs.entity.Recommend;
import com.pg.bbs.entity.Users;
import com.pg.bbs.handler.BusinessException;
import com.pg.bbs.service.RecommendService;
import com.pg.bbs.util.JwtGetUserInterceptor;
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
        // 获取用户信息
        String userId = JwtGetUserInterceptor.getUserId();
        recommend.setUuid(UUID.randomUUID().toString().replace("-", ""));
        recommend.setUserId(userId);
        recommend.setVotes(0);
        recommend.setViewsWord(0);
        recommend.setCreateTime(new Date());
        recommend.setModifyTime(new Date());
        return recommendMapper.insert(recommend);
    }

    @Override
    public int update(Recommend recommend) {
        if (StringUtil.isEmpty(recommend.getUuid())) {
            throw new BusinessException(500, "uuid必传");
        }
        recommend.setModifyTime(new Date());
        return recommendMapper.update(recommend);
    }
}
