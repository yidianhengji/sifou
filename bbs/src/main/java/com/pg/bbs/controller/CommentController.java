package com.pg.bbs.controller;

import com.pg.bbs.entity.Comment;
import com.pg.bbs.entity.Recommend;
import com.pg.bbs.handler.BusinessStatus;
import com.pg.bbs.handler.Result;
import com.pg.bbs.service.CommentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Api(tags = "评论回复模块")
@RequestMapping("/api/comment")
@RestController
public class CommentController {

    @Resource
    private CommentService commentService;

    @ApiOperation("新增评论回复模块")
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public Result<Comment> insert(@RequestBody Comment comment) {
        commentService.insert(comment);
        return new Result<>(BusinessStatus.SUCCESS);
    }

    @ApiOperation("查询评论回复模块")
    @RequestMapping(value = "/queryComment", method = RequestMethod.GET)
    public Result<List<Comment>> queryRecommendById(@RequestParam String recommendId) {
        List<Comment> list = commentService.queryRecommendById(recommendId);
        return new Result<List<Comment>>(BusinessStatus.SUCCESS, list);
    }

    @ApiOperation("删除评论回复模块")
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public Result<Comment> delete(@RequestParam String uuid) {
        commentService.delete(uuid);
        return new Result<>(BusinessStatus.SUCCESS);
    }

}
