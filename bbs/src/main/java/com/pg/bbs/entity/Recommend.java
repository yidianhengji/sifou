package com.pg.bbs.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@ApiModel(description = "文章、问答表")
@Data
public class Recommend {

    @ApiModelProperty(value = "文章/问答id")
    private String uuid;

    @ApiModelProperty(value = "标题")
    private String title;

    @ApiModelProperty(value = "列表展示字段")
    private String excerpt;

    @ApiModelProperty(value = "封面图")
    private String imageUrl;

    @ApiModelProperty(value = "用户id")
    private String userId;

    @ApiModelProperty(value = "标签id")
    private String labels;

    @ApiModelProperty(value = "投票数")
    private Integer votes;

    @ApiModelProperty(value = "阅读数")
    private Integer viewsWord;

    @ApiModelProperty(value = "富文本内容")
    private String content;

    @ApiModelProperty(value = "1、草稿箱  2、审核中 3、推荐")
    private Integer status;

    @ApiModelProperty(value = "1 文章  2 问答")
    private Integer type;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "更新时间")
    private Date modifyTime;

}
