package com.demo.factory.goods;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "实物商品")
public class DeliverReq {

    @ApiModelProperty(value = "用户姓名")
    private String userName;              // 用户姓名
    @ApiModelProperty(value = "用户手机")
    private String userPhone;             // 用户手机
    @ApiModelProperty(value = "商品SKU")
    private String sku;                   // 商品SKU
    @ApiModelProperty(value = "订单ID")
    private String orderId;               // 订单ID
    @ApiModelProperty(value = "收货人姓名")
    private String consigneeUserName;     // 收货人姓名
    @ApiModelProperty(value = "收货人手机")
    private String consigneeUserPhone;    // 收货人手机
    @ApiModelProperty(value = "收货人地址")
    private String consigneeUserAddress;  // 收获人地址

}
