package com.adapter.model.mq;

import com.alibaba.fastjson.JSON;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 注册开户MQ
 */
@ApiModel(value = "注册开户MQ")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class create_account {
    @ApiModelProperty(value = "开户编号")
    private String number;
    @ApiModelProperty(value = "开户地")
    private String address;
    @ApiModelProperty(value = "开户时间")
    private Date accountDate;
    @ApiModelProperty(value = "开户描述")
    private String desc;

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
