package com.pg.bbs.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(description = "用戶登录字段")
@Data
public class UsersSignIn {

    @ApiModelProperty(value = "手机号码")
    private String phone;

    @ApiModelProperty(value = "用户密码")
    private String password;
}
