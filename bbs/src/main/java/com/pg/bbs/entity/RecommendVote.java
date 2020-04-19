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

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getRecommendId() {
        return recommendId;
    }

    public void setRecommendId(String recommendId) {
        this.recommendId = recommendId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
