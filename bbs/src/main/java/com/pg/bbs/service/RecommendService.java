package com.pg.bbs.service;

import com.github.pagehelper.Page;
import com.pg.bbs.dto.CollectDto;
import com.pg.bbs.dto.RecommendDto;
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
    void collect(CollectDto collectDto);

    /**
     * 文章、问答点赞
     * @param recommendId
     */
    int vote(String recommendId);

    /**
     * 查询频道下面的文章
     * @param recommendDto
     */
    Page<Recommend> queryAll(RecommendDto recommendDto);

    /**
     * 批量数据采集
     */
    void collectAll();
}
