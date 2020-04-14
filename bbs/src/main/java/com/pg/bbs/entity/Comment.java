package com.pg.bbs.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

@ApiModel(description = "评论表")
@Data
public class Comment {

    @ApiModelProperty(value = "评论id")
    private String uuid;

    @ApiModelProperty(value = "父级id")
    private String parentId;

    @ApiModelProperty(value = "文章id/问答id")
    private String recommendId;

    @ApiModelProperty(value = "用户id")
    private String userId;

    @ApiModelProperty(value = "用户名称")
    private String userName;

    @ApiModelProperty(value = "用户头像")
    private String userImageUrl;

    @ApiModelProperty(value = "点赞数")
    private Integer likeNumber;

    @ApiModelProperty(value = "评论内容")
    private String content;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "子集")
    private List<Comment> children;

}
