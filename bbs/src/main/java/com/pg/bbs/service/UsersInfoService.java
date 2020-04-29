package com.pg.bbs.service;

import com.pg.bbs.entity.UsersInfo;

import java.util.List;

public interface UsersInfoService {

    /**
     * 查询全部记录
     * @return
     */
    List<UsersInfo> queryAll();

    /**
     * 查询单条记录
     * @param uuid
     */
    UsersInfo queryOne(String uuid);

    /**
     * 新增
     * @param usersInfo
     */
    int insert(UsersInfo usersInfo);

    /**
     * 修改
     * @param usersInfo
     */
    int update(UsersInfo usersInfo);

    /**
     * 刪除
     * @param uuid
     */
    int delete(String uuid);

}
