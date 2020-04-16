package com.pg.bbs.dao;

import com.pg.bbs.dto.UsersSignIn;
import com.pg.bbs.dto.UsersSignUp;
import com.pg.bbs.entity.Users;

public interface UsersMapper {

    /**
     * 登录
     * @param phone
     */
    Users signIn(String phone);

    /**
     * 用户注册
     * @param usersSignUp
     */
    int signUp(UsersSignUp usersSignUp);

    /**
     * 判断手机号码是否存在
     * @param phone
     */
    int getUserPhone(String phone);

    /**
     * 根据用户id查询用户信息
     * @param uuid
     */
    Users findUserById(String uuid);

    /**
     * 随机取一条数据
     */
    Users randomData();

}
