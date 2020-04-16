package com.pg.bbs.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(description = "采集字段")
@Data
public class CollectDto {

    @ApiModelProperty(value = "频道id")
    private String channelsId;

    @ApiModelProperty(value = "频道地址")
    private String channelsPath;
}
