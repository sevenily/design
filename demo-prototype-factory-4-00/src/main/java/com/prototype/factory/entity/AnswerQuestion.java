package com.prototype.factory.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ApiModel(value = "问答题")
public class AnswerQuestion {
    @ApiModelProperty(name = "name", value = "问题")
    private String name;
    @ApiModelProperty(name = "key", value = "答案")
    private String key;
}
