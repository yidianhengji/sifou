package com.pg.bbs.controller;

import com.github.pagehelper.Page;
import com.pg.bbs.dto.ChannelsDto;
import com.pg.bbs.entity.Channels;
import com.pg.bbs.handler.BusinessStatus;
import com.pg.bbs.handler.PageInfo;
import com.pg.bbs.handler.Result;
import com.pg.bbs.handler.ResultPage;
import com.pg.bbs.service.ChannelsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@Api(tags = "频道模块")
@RequestMapping("/api/channels")
@RestController
public class ChannelsController {

    @Resource
    private ChannelsService channelsService;

    @ApiOperation("新增频道")
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public Result<Channels> insert(@RequestBody Channels channels) {
        channelsService.insert(channels);
        return new Result<Channels>(BusinessStatus.SUCCESS);
    }

    @ApiOperation("修改频道")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Result<Channels> update(@RequestBody Channels channels) {
        channelsService.update(channels);
        return new Result<Channels>(BusinessStatus.SUCCESS);
    }

    @ApiOperation("分页查询频道")
    @RequestMapping(value = "/queryAll", method = RequestMethod.POST)
    public ResultPage<Channels> queryAll(@RequestBody ChannelsDto channelsDto) {
        Page<Channels> one = channelsService.queryAll(channelsDto);
        PageInfo<Channels> pageinfo = new PageInfo<>(one);
        return new ResultPage<Channels>(BusinessStatus.SUCCESS, pageinfo);
    }

    @ApiOperation("查询全部频道")
    @RequestMapping(value = "/queryList", method = RequestMethod.GET)
    public Result<List<Channels>> queryList() {
        List<Channels> channels = channelsService.queryList();
        return new Result<List<Channels>>(BusinessStatus.SUCCESS, channels);
    }
}
