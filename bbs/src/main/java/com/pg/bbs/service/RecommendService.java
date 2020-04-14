package com.pg.bbs.service;

import com.pg.bbs.entity.Recommend;

public interface RecommendService {
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
     * 查询文章、问答详情
     * @param uuid
     */
    Recommend findById(String uuid);

    /**
     * 数据采集
     */
    void collect();
}
