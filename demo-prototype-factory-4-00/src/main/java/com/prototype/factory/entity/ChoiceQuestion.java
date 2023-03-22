package com.prototype.factory.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ApiModel(value = "选择题")
public class ChoiceQuestion {

    @ApiModelProperty(name = "name", value = "题目")
    private String name;
    @ApiModelProperty(name = "option", value = "选项")
    private Map<String, String> option;
    @ApiModelProperty(name = "key", value = "答案")
    private String key;


}
