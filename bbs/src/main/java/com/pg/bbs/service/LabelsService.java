package com.pg.bbs.service;

import com.pg.bbs.entity.Labels;

import java.util.List;

public interface LabelsService {

    /**
     * 查询标签详情
     * @param uuid
     */
    List<Labels> queryOne(String uuid);
    
    /**
     * 新增标签
     * @param labels
     */
    int insert(Labels labels);

    /**
     * 修改标签
     * @param labels
     */
    int update(Labels labels);

    /**
     * 删除标签
     * @param uuid
     */
    int delete(String uuid);
}
