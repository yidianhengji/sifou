package com.pg.bbs.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(description = "采集字段")
@Data
public class RecommendDto {

    @ApiModelProperty(value = "页数")
    private Integer pageSize;

    @ApiModelProperty(value = "页码")
    private Integer pageNum;

    @ApiModelProperty(value = "频道id")
    private String channelsId;

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public String getChannelsId() {
        return channelsId;
    }

    public void setChannelsId(String channelsId) {
        this.channelsId = channelsId;
    }
}
