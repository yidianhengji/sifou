package com.pg.bbs.service;

import com.pg.bbs.dto.UsersSignIn;
import com.pg.bbs.dto.UsersSignUp;
import com.pg.bbs.entity.Users;

public interface UsersService {

    /**
     * 用戶注冊
     * @param usersSignUp
     */
    int signUp(UsersSignUp usersSignUp);

    /**
     * 用户登录
     * @param usersSignIn
     */
    Users signIn(UsersSignIn usersSignIn);

}
