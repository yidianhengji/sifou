package com.pg.bbs.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.util.StringUtil;
import com.pg.bbs.dao.ChannelsMapper;
import com.pg.bbs.dto.ChannelsDto;
import com.pg.bbs.entity.Channels;
import com.pg.bbs.handler.BusinessException;
import com.pg.bbs.service.ChannelsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class ChannelsServiceImpl implements ChannelsService {

    @Resource
    private ChannelsMapper channelsMapper;

    @Override
    public int insert(Channels channels) {
        channels.setUuid(UUID.randomUUID().toString().replace("-", ""));
        channels.setCreateTime(new Date());
        channels.setModifyTime(new Date());
        return channelsMapper.insert(channels);
    }

    @Override
    public int update(Channels channels) {
        if (StringUtil.isEmpty(channels.getUuid())) {
            throw new BusinessException(500, "uuid必传");
        }
        channels.setModifyTime(new Date());
        return channelsMapper.update(channels);
    }

    @Override
    public Page<Channels> queryAll(ChannelsDto channelsDto) {
        if (channelsDto.getPageSize() != null && channelsDto.getPageNum() != null) {
            PageHelper.startPage(channelsDto.getPageNum(), channelsDto.getPageSize());
        }
        Page<Channels> pages = this.channelsMapper.queryAll(channelsDto);
        return pages;
    }

    @Override
    public List<Channels> queryList() {
        List<Channels> channelsList = this.channelsMapper.queryList();
        return channelsList;
    }
}
