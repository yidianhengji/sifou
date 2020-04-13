package com.pg.bbs.controller;

import com.auth0.jwt.JWT;
import com.pg.bbs.entity.Labels;
import com.pg.bbs.handler.BusinessStatus;
import com.pg.bbs.handler.Result;
import com.pg.bbs.service.LabelsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Api(tags = "标签模块")
@RequestMapping("/api/labels")
@RestController
public class LabelsContoller {

    @Resource
    private LabelsService labelsService;

    @ApiOperation("根据uuid查询单个标签")
    @RequestMapping(value = "/queryOne", method = RequestMethod.GET)
    public Result<List<Labels>> queryOne(@RequestParam String uuid) {
        List<Labels> list = labelsService.queryOne(uuid);
        return new Result<List<Labels>>(BusinessStatus.SUCCESS, list);
    }

    @ApiOperation("新增标签")
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public Result<Labels> insert(@RequestBody Labels labels) {
        labelsService.insert(labels);
        return new Result<Labels>(BusinessStatus.SUCCESS);
    }

    @ApiOperation("修改标签")
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public Result<Labels> update(@RequestBody Labels labels) {
        labelsService.update(labels);
        return new Result<Labels>(BusinessStatus.SUCCESS);
    }

    @ApiOperation("删除标签")
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public Result<Labels> update(@RequestParam String uuid) {
        labelsService.delete(uuid);
        return new Result<Labels>(BusinessStatus.SUCCESS);
    }

}
