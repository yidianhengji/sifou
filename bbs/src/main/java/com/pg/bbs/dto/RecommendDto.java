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

    @ApiModelProperty(value = "类型")
    private String channelsType;

}
