package com.pg.bbs.controller;

import com.pg.bbs.dto.UsersSignIn;
import com.pg.bbs.dto.UsersSignUp;
import com.pg.bbs.entity.Recommend;
import com.pg.bbs.entity.Users;
import com.pg.bbs.handler.BusinessStatus;
import com.pg.bbs.handler.Result;
import com.pg.bbs.service.UsersService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Api(tags = "用户模块")
@RequestMapping("/api/user")
@RestController
public class UsersController {

    @Resource
    private UsersService usersService;

    @ApiOperation("用户注册")
    @RequestMapping(value = "/signUp", method = RequestMethod.POST)
    public Result<Users> signUp(@RequestBody UsersSignUp usersSignUp) {
        usersService.signUp(usersSignUp);
        return new Result<Users>(BusinessStatus.SUCCESS);
    }

    @ApiOperation("用户登录")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Result<Users> signIn(@RequestBody UsersSignIn usersSignIn) {
        Users users = usersService.signIn(usersSignIn);
        return new Result<Users>(BusinessStatus.SUCCESS, users);
    }
}
