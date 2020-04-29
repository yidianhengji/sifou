package com.pg.bbs.service.impl;

import com.github.pagehelper.util.StringUtil;
import com.pg.bbs.dao.UsersInfoMapper;
import com.pg.bbs.entity.UsersInfo;
import com.pg.bbs.handler.BusinessException;
import com.pg.bbs.service.UsersInfoService;
import com.pg.bbs.util.JwtGetUserInterceptor;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

@Service
public class UsersInfoServiceImpl implements UsersInfoService {

    @Resource
    private UsersInfoMapper usersInfoMapper;

    @Override
    public List<UsersInfo> queryAll() {
        String userId = JwtGetUserInterceptor.getUserId();
        List<UsersInfo> infoList = usersInfoMapper.queryAll(userId);
        return infoList;
    }

    @Override
    public UsersInfo queryOne(String uuid) {
        if (StringUtil.isEmpty(uuid)) {
            throw new BusinessException(500, "uuid必传");
        }
        return usersInfoMapper.queryOne(uuid);
    }

    @Override
    public int insert(UsersInfo usersInfo) {
        // 获取用户信息
        String userId = JwtGetUserInterceptor.getUserId();
        usersInfo.setUuid(UUID.randomUUID().toString().replace("-", ""));
        usersInfo.setUserId(userId);
        return usersInfoMapper.insert(usersInfo);
    }

    @Override
    public int update(UsersInfo usersInfo) {
        if (StringUtil.isEmpty(usersInfo.getUuid())) {
            throw new BusinessException(500, "uuid必传");
        }
        return usersInfoMapper.update(usersInfo);
    }

    @Override
    public int delete(String uuid) {
        if (StringUtil.isEmpty(uuid)) {
            throw new BusinessException(500, "uuid必传");
        }
        return usersInfoMapper.delete(uuid);
    }
}
