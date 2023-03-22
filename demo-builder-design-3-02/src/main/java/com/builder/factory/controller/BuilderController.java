package com.builder.factory.controller;

import com.builder.factory.Builder;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@Api(tags = "建造者测试")
public class BuilderController {

    @GetMapping("/testBuilder/{area}/{id}")
    @ApiOperation(value = "根据面积和装修类型获取装修信息", tags = "根据面积和装修类型获取装修信息")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "area", value = "面积"),
            @ApiImplicitParam(paramType = "path", name = "id", value = "类型")
    })
    public String testBuilder(@PathVariable BigDecimal area, @PathVariable int id){
        Builder builder = new Builder();
        String detail = null;
        /*if (1 == id){
            detail = builder.levelOne(area, id).getDetail();
        } else if (2 == id){
            detail = builder.levelTwo(area, id).getDetail();
        } else if (3 == id){
            detail = builder.levelThree(area, id).getDetail();
        }*/

        switch (id) {
            case 1:
                detail = builder.levelOne(area, id).getDetail();
                break;
            case 2:
                detail = builder.levelTwo(area, id).getDetail();
                break;
            case 3:
                detail = builder.levelThree(area, id).getDetail();
                break;
            default:
                detail = "类型不存在";
        }
        return detail;
    }

}
