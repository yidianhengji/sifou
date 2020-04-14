package com.pg.bbs.service;

import com.pg.bbs.entity.Comment;

import java.util.List;

public interface CommentService {

    /**
     * 新增评论、回复
     * @param comment
     */
    int insert(Comment comment);

    /**
     * 根据文章或问题id查询评论
     * @param recommendId
     */
    List<Comment> queryRecommendById(String recommendId);

    /**
     * 删除评论或回复
     * @param uuid
     */
    int delete(String uuid);
}
