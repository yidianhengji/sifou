package com.pg.bbs.dao;

import com.github.pagehelper.Page;
import com.pg.bbs.dto.ChannelsDto;
import com.pg.bbs.entity.Channels;

import java.util.List;

public interface ChannelsMapper {
    /**
     * 新增频道
     * @param channels
     */
    int insert(Channels channels);

    /**
     * 修改频道
     * @param channels
     */
    int update(Channels channels);

    /**
     * 分页查询频道
     * @param channelsDto
     */
    Page<Channels> queryAll(ChannelsDto channelsDto);

    /**
     * 查询全部频道
     */
    List<Channels> queryList();
}
