package com.pg.bbs.controller;

import com.pg.bbs.entity.UsersInfo;
import com.pg.bbs.handler.BusinessStatus;
import com.pg.bbs.handler.Result;
import com.pg.bbs.service.UsersInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Api(tags = "用户模块-工作经历-教育经历-开源项目")
@RequestMapping("/api/userinfo")
@RestController
public class UsersInfoController {

    @Resource
    private UsersInfoService usersInfoService;

    @ApiOperation("新增")
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public Result<UsersInfo> insert(@RequestBody UsersInfo usersInfo) {
        usersInfoService.insert(usersInfo);
        return new Result<UsersInfo>(BusinessStatus.SUCCESS);
    }

    @ApiOperation("修改")
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public Result<UsersInfo> update(@RequestBody UsersInfo usersInfo) {
        usersInfoService.update(usersInfo);
        return new Result<UsersInfo>(BusinessStatus.SUCCESS);
    }

    @ApiOperation("查询单条记录")
    @RequestMapping(value = "/queryOne", method = RequestMethod.GET)
    public Result<UsersInfo> queryOne(@RequestParam String uuid) {
        UsersInfo info = usersInfoService.queryOne(uuid);
        return new Result<>(BusinessStatus.SUCCESS, info);
    }

    @ApiOperation("根据类型查询")
    @RequestMapping(value = "/queryAll", method = RequestMethod.GET)
    public Result<List<UsersInfo>> queryAll() {
        List<UsersInfo> list = usersInfoService.queryAll();
        return new Result<List<UsersInfo>>(BusinessStatus.SUCCESS, list);
    }

    @ApiOperation("删除")
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public Result<UsersInfo> delete(@RequestParam String uuid) {
        usersInfoService.delete(uuid);
        return new Result<>(BusinessStatus.SUCCESS);
    }

}
