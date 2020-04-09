package com.pg.bbs.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@ApiModel(description = "标签表")
@Data
public class Labels {

    @ApiModelProperty(value = "标签id")
    private String uuid;

    @ApiModelProperty(value = "频道id")
    private String channelsId;

    @ApiModelProperty(value = "标签名称")
    private String name;

    @ApiModelProperty(value = "图标")
    private String iconUrl;

    @ApiModelProperty(value = "描述")
    private String description;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "修改时间")
    private Date modifyTime;

}
