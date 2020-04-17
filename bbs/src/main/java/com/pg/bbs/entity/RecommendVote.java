package com.pg.bbs.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(description = "文章、问答点赞表")
@Data
public class RecommendVote {

    @ApiModelProperty(value = "点赞id")
    private String uuid;

    @ApiModelProperty(value = "文章/问答id")
    private String recommendId;

    @ApiModelProperty(value = "用户id")
    private String userId;
}
