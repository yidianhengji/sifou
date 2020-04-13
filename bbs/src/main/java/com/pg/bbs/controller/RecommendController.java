package com.pg.bbs.controller;

import com.pg.bbs.entity.Recommend;
import com.pg.bbs.handler.BusinessStatus;
import com.pg.bbs.handler.Result;
import com.pg.bbs.service.RecommendService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Api(tags = "文章问答模块")
@RequestMapping("/api/recommend")
@RestController
public class RecommendController {

    @Resource
    private RecommendService recommendService;

    @ApiOperation("新增文章/问答")
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public Result<Recommend> insert(@RequestBody Recommend recommend) {
        recommendService.insert(recommend);
        return new Result<Recommend>(BusinessStatus.SUCCESS);
    }

    @ApiOperation("修改文章/问答")
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public Result<Recommend> update(@RequestBody Recommend recommend) {
        recommendService.update(recommend);
        return new Result<Recommend>(BusinessStatus.SUCCESS);
    }

    @ApiOperation("文章数据采集")
    @RequestMapping(value = "/collect", method = RequestMethod.POST)
    public Result<Recommend> collect() {
        recommendService.collect();
        return new Result<Recommend>(BusinessStatus.SUCCESS);
    }

}
