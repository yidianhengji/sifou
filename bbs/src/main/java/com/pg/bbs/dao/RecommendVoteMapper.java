package com.pg.bbs.dao;

import com.pg.bbs.entity.RecommendVote;
import org.apache.ibatis.annotations.Param;

public interface RecommendVoteMapper {

    /**
     * 新增点赞
     * @return
     */
    int insert(RecommendVote recommendVote);

    /**
     * 查询是否有记录
     * @param recommendId
     * @param userId
     */
    int queryFindList(@Param("recommendId") String recommendId, @Param("userId") String userId);

    /**
     * 删除记录
     * @param recommendId
     * @param userId
     */
    int delete(@Param("recommendId") String recommendId, @Param("userId") String userId);

    /**
     * 查询点赞数量
     * @param recommendId
     */
    int queryCount(String recommendId);
}
