package com.pg.bbs.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@ApiModel(description = "用户表")
@Data
public class UsersInfo {

    @ApiModelProperty(value = "id")
    private String uuid;

    @ApiModelProperty(value = "用户id")
    private String userId;

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "子标题")
    private String nameSub;

    @ApiModelProperty(value = "开始时间")
    private Date startTime;

    @ApiModelProperty(value = "结束时间")
    private Date endTime;

    @ApiModelProperty(value = "判断结束时间是否要填")
    private Boolean isTime;

    @ApiModelProperty(value = "所在城市")
    private String city;

    @ApiModelProperty(value = "标签id")
    private String labelId;

    @ApiModelProperty(value = "描述")
    private String description;

    @ApiModelProperty(value = "1、工作经历 2、教育经历 3、开源项目")
    private Integer type;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameSub() {
        return nameSub;
    }

    public void setNameSub(String nameSub) {
        this.nameSub = nameSub;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Boolean getTime() {
        return isTime;
    }

    public void setTime(Boolean isTime) {
        this.isTime = isTime;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getLabelId() {
        return labelId;
    }

    public void setLabelId(String labelId) {
        this.labelId = labelId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
