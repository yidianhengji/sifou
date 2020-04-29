package com.pg.bbs.dao;

import com.pg.bbs.entity.UsersInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UsersInfoMapper {

    /**
     * 查询全部记录
     * @param userId
     */
    List<UsersInfo> queryAll(String userId);

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
