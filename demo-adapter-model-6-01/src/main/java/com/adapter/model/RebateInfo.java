package com.adapter.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 统一的MQ消息体
 * MQ消息适配
 */
@ApiModel(value = "统一的MQ消息体")
@AllArgsConstructor
@NoArgsConstructor
public class RebateInfo {
    @ApiModelProperty(value = "用户Id")
    private String userId;
    @ApiModelProperty(value = "业务Id")
    private String bizId;
    @ApiModelProperty(value = "业务时间")
    private Date bizTime;
    @ApiModelProperty(value = "业务描述")
    private String desc;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getBizId() {
        return bizId;
    }

    public void setBizId(String bizId) {
        this.bizId = bizId;
    }

    public Date getBizTime() {
        return bizTime;
    }

    public void setBizTime(Date bizTime) {
        this.bizTime = bizTime;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
