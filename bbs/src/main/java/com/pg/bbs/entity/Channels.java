package com.pg.bbs.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

@ApiModel(description = "频道表")
@Data
public class Channels {

    @ApiModelProperty(value = "频道id")
    private String uuid;

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "地址")
    private String url;

    @ApiModelProperty(value = "图标")
    private String iconUrl;

    @ApiModelProperty(value = "标签列表")
    private List<Labels> labelList;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "更新时间")
    private Date modifyTime;

}
