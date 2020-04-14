package com.pg.bbs.dao;

import com.pg.bbs.entity.Recommend;

public interface RecommendMapper {
    /**
     * 新增文章、问答
     * @param recommend
     */
    int insert(Recommend recommend);

    /**
     * 修改文章、问答
     * @param recommend
     */
    int update(Recommend recommend);

    /**
     * 根据标题查询
     * @param title
     */
    int findQueryTitle(String title);

    /**
     * 查询文章、问答详情
     * @param uuid
     */
    Recommend findById(String uuid);

}
