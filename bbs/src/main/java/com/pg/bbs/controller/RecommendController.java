package com.pg.bbs.controller;

import com.github.pagehelper.Page;
import com.pg.bbs.dto.CollectDto;
import com.pg.bbs.dto.RecommendDto;
import com.pg.bbs.entity.Recommend;
import com.pg.bbs.handler.BusinessStatus;
import com.pg.bbs.handler.PageInfo;
import com.pg.bbs.handler.Result;
import com.pg.bbs.handler.ResultPage;
import com.pg.bbs.service.RecommendService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

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
    public Result<Recommend> collect(@RequestBody CollectDto collectDto) {
        recommendService.collect(collectDto);
        return new Result<Recommend>(BusinessStatus.SUCCESS);
    }

    @ApiOperation("采集全部频道")
    @RequestMapping(value = "/collectAll", method = RequestMethod.POST)
    public Result<Recommend> collect() {
        recommendService.collectAll();
        return new Result<Recommend>(BusinessStatus.SUCCESS);
    }

    @ApiOperation("查询文章、问答详情")
    @RequestMapping(value = "/queryOne", method = RequestMethod.GET)
    public Result<Recommend> findById(@RequestParam String uuid) {
        Recommend list = recommendService.findById(uuid);
        Recommend recommend = new Recommend();
        recommend.setUuid(list.getUuid());
        int viewsWord = list.getViewsWord();
        int num = viewsWord + 1;
        recommend.setViewsWord(num);
        recommendService.update(recommend);
        return new Result<Recommend>(BusinessStatus.SUCCESS, list);
    }

    @ApiOperation("文章、问答点赞")
    @RequestMapping(value = "/vote", method = RequestMethod.GET)
    public Result<Integer> vote(@RequestParam String recommendId) {
        int vote = recommendService.vote(recommendId);
        return new Result<Integer>(BusinessStatus.SUCCESS, vote);
    }

    @ApiOperation("查询文章列表")
    @RequestMapping(value = "queryAll", method = RequestMethod.POST)
    public ResultPage<Recommend> queryAll(@RequestBody RecommendDto recommendDto) {
        Page<Recommend> one = recommendService.queryAll(recommendDto);
        PageInfo<Recommend> pageinfo = new PageInfo<>(one);
        return new ResultPage<Recommend>(BusinessStatus.SUCCESS, pageinfo);
    }

}
