package com.pg.bbs.controller;

import com.pg.bbs.dto.UsersSignIn;
import com.pg.bbs.dto.UsersSignUp;
import com.pg.bbs.entity.Recommend;
import com.pg.bbs.entity.Users;
import com.pg.bbs.handler.BusinessStatus;
import com.pg.bbs.handler.Result;
import com.pg.bbs.service.UsersService;
import com.pg.bbs.util.JwtGetUserInterceptor;
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
    public Result<String> signIn(@RequestBody UsersSignIn usersSignIn) {
        String token = usersService.signIn(usersSignIn);
        return new Result<String>(BusinessStatus.SUCCESS, token);
    }

    @ApiOperation("获取用户信息")
    @RequestMapping(value = "/userInfo", method = RequestMethod.GET)
    public Result<Users> userInfo() {
        String userId = JwtGetUserInterceptor.getUserId();
        Users user = usersService.findUserById(userId);
        return new Result<>(BusinessStatus.SUCCESS, user);
    }

}
