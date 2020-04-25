package com.pg.bbs.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    @ApiModelProperty(value = "用户昵称")
    private String userNickname;

    @ApiModelProperty(value = "用户头像")
    private String userUrl;

    @ApiModelProperty(value = "频道id")
    private String channelsId;

    @ApiModelProperty(value = "标签id")
    private String labels;

    @ApiModelProperty(value = "投票数")
    private Integer votes;

    @ApiModelProperty(value = "阅读数")
    private Integer viewsWord;

    @ApiModelProperty(value = "富文本内容")
    private String content;

    @ApiModelProperty(value = "markdown内容")
    private String markdownContent;

    @ApiModelProperty(value = "1、草稿箱 2、推荐")
    private Integer status;

    @ApiModelProperty(value = "1 文章  2 问答")
    private Integer type;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "更新时间")
    private Date modifyTime;

    @ApiModelProperty(value = "标签集合")
    private List<Object> labelArr = new ArrayList<>();

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getExcerpt() {
        return excerpt;
    }

    public void setExcerpt(String excerpt) {
        this.excerpt = excerpt;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserNickname() {
        return userNickname;
    }

    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname;
    }

    public String getUserUrl() {
        return userUrl;
    }

    public void setUserUrl(String userUrl) {
        this.userUrl = userUrl;
    }

    public String getChannelsId() {
        return channelsId;
    }

    public void setChannelsId(String channelsId) {
        this.channelsId = channelsId;
    }

    public String getLabels() {
        return labels;
    }

    public void setLabels(String labels) {
        this.labels = labels;
    }

    public Integer getVotes() {
        return votes;
    }

    public void setVotes(Integer votes) {
        this.votes = votes;
    }

    public Integer getViewsWord() {
        return viewsWord;
    }

    public void setViewsWord(Integer viewsWord) {
        this.viewsWord = viewsWord;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getMarkdownContent() {
        return markdownContent;
    }

    public void setMarkdownContent(String markdownContent) {
        this.markdownContent = markdownContent;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public List<Object> getLabelArr() {
        return labelArr;
    }

    public void setLabelArr(List<Object> labelArr) {
        this.labelArr = labelArr;
    }
}
