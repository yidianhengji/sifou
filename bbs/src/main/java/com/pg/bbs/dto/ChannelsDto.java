package com.pg.bbs.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(description = "频道dto")
@Data
public class ChannelsDto {

    @ApiModelProperty(value = "页数")
    private Integer pageSize;

    @ApiModelProperty(value = "页码")
    private Integer pageNum;
}
