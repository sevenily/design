package com.demo.factory.coupon;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "优惠券")
public class CouponResult {

    @ApiModelProperty(value = "编码")
    private String code; // 编码
    @ApiModelProperty(value = "描述")
    private String info; // 描述

}
