package com.demo.factory.award;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "奖品请求体")
public class AwardReq {

    @ApiModelProperty(value = "用户唯一ID")
    private String uId;                 // 用户唯一ID
    @ApiModelProperty(value = "奖品类型")
    private Integer awardType;          // 奖品类型(可以用枚举定义)；1优惠券、2实物商品、3第三方兑换卡(爱奇艺)
    @ApiModelProperty(value = "奖品编号")
    private String awardNumber;         // 奖品编号；sku、couponNumber、cardId
    @ApiModelProperty(value = "业务ID，防重复")
    private String bizId;               // 业务ID，防重复
    @ApiModelProperty(value = "拓展信息")
    private Map<String, String> extMap; // 扩展信息

    }
