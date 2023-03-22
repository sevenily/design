package com.adapter.model.mq;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@ApiModel(value = "第三方订单MQ")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class POPOrderDelivered {
    @ApiModelProperty(value = "用户ID")
    private String uid;
    @ApiModelProperty(value = "订单号")
    private String orderId;
    @ApiModelProperty(value = "下单时间")
    private Date orderTime;
    @ApiModelProperty(value = "商品")
    private Date sku;
    @ApiModelProperty(value = "商品名称")
    private Date skuName;
    @ApiModelProperty(value = "金额")
    private BigDecimal decimal;
}
