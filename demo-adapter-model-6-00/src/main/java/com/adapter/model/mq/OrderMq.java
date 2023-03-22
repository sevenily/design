package com.adapter.model.mq;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@ApiModel(value = "内部订单MQ")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderMq {
    @ApiModelProperty(value = "用户ID")
    private String uid;
    @ApiModelProperty(value = "商品")
    private String sku;
    @ApiModelProperty(value = "订单ID")
    private String orderId;
    @ApiModelProperty(value = "下单时间")
    private Date createOrderTime;
}
