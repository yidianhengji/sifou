package com.pg.bbs.dao;

import com.pg.bbs.entity.Labels;

import java.util.List;

public interface LabelsMapper {

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

    /**
     * 根据name查询
     * @param name
     */
    int findName(String name);

    /**
     * 根据name查询数据
     * @param name
     */
    Labels findListNameData(String name);

    /**
     * 根据逗号分隔的数据查询list
     */
    List<Labels> findSplitData(String ids);

}
