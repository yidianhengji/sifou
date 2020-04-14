package com.pg.bbs.service.impl;

import com.pg.bbs.dao.CommentMapper;
import com.pg.bbs.entity.Comment;
import com.pg.bbs.service.CommentService;
import com.pg.bbs.util.JwtGetUserInterceptor;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class CommentServiceImpl implements CommentService {

    @Resource
    private CommentMapper commentMapper;

    @Override
    public int insert(Comment comment) {
        // 获取用户信息
        String userId = JwtGetUserInterceptor.getUserId();
        comment.setUuid(UUID.randomUUID().toString().replace("-", ""));
        comment.setUserId(userId);
        comment.setLikeNumber(0);
        comment.setCreateTime(new Date());
        return commentMapper.insert(comment);
    }

    @Override
    public List<Comment> queryRecommendById(String recommendId) {
        List<Comment> commentList = commentMapper.queryRecommendById(recommendId);
        List<Comment> childs = getChilds(commentList, "");
        return childs;
    }

    public List<Comment> getChilds(List<Comment> list, String parent) {
        List<Comment> listTree = new ArrayList<Comment>();
        for (Comment comment : list) {
            String uuid = comment.getUuid();
            String parentId = comment.getParentId();
            if (parent.equals(parentId)) {
                List<Comment> comments = getChilds(list, uuid);
                comment.setChildren(comments);
                listTree.add(comment);
            }
        }
        return listTree;
    }

    @Override
    public int delete(String uuid) {
        // 把前端传过来的uuid先进行主键删除，再根据父级字段删除
        int deleteUuid = commentMapper.deleteUuid(uuid);
        commentMapper.deleteParentId(uuid);
        return deleteUuid;
    }
}
