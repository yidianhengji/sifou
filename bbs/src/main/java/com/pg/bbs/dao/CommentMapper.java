package com.pg.bbs.dao;

import com.pg.bbs.entity.Comment;

import java.util.List;

public interface CommentMapper {

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
     * 根据uuid删除
     * @param uuid
     */
    int deleteUuid(String uuid);

    /**
     * 根据parentId删除
     * @param parentId
     */
    int deleteParentId(String parentId);
}
