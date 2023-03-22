package com.builder.factory.controller;

import com.builder.factory.Matter;
import com.builder.factory.ceilling.LevelOneCeiling;
import com.builder.factory.ceilling.LevelTwoCeiling;
import com.builder.factory.coat.DuluxCoat;
import com.builder.factory.coat.LiBangCoat;
import com.builder.factory.floor.ShengXiangFloor;
import com.builder.factory.tile.DongPengTile;
import com.builder.factory.tile.MarcoPoloTile;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
@Api(tags = "构造者模式")
public class DecorationPackageController {


    @GetMapping(value = "/matterList/{area}/{level}")
    @ApiOperation(value = "获取装修模式", tags = "获取装修模式")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "area", value = "area"),
            @ApiImplicitParam(paramType = "path", name = "level", value = "level")})
    public String matterList(@PathVariable BigDecimal area, @PathVariable Integer level){
        // 装修清单
        List<Matter> list = new ArrayList<Matter>();
        BigDecimal price = BigDecimal.ZERO; // 装修价格
        // 豪华欧式
        if (1 == level){
            LevelTwoCeiling levelTwoCeiling = new LevelTwoCeiling();
            DuluxCoat duluxCoat = new DuluxCoat();
            ShengXiangFloor shengXiangFloor = new ShengXiangFloor();

            list.add(levelTwoCeiling);
            list.add(duluxCoat);
            list.add(shengXiangFloor);

            price = price.add(area.multiply(new BigDecimal("0.2"))).multiply(levelTwoCeiling.price());
            price = price.add(area.multiply(new BigDecimal("1.4"))).multiply(duluxCoat.price());
            price = price.add(area.multiply(area.multiply(shengXiangFloor.price())));
        }

        // 轻奢田园
        if (2 == level){
            LevelTwoCeiling levelTwoCeiling = new LevelTwoCeiling();
            LiBangCoat liBangCoat = new LiBangCoat();
            MarcoPoloTile marcoPoloTile = new MarcoPoloTile();

            list.add(levelTwoCeiling);
            list.add(liBangCoat);
            list.add(marcoPoloTile);

            price = price.add(area.multiply(new BigDecimal("0.2"))).multiply(levelTwoCeiling.price());
            price = price.add(area.multiply(new BigDecimal("1.4"))).multiply(liBangCoat.price());
            price = price.add(area.multiply(area.multiply(marcoPoloTile.price())));
        }

        // 现代简约
        if (3 == level){
            LevelOneCeiling levelOneCeiling = new LevelOneCeiling();
            LiBangCoat liBangCoat = new LiBangCoat();
            DongPengTile dongPengTile = new DongPengTile();

            list.add(levelOneCeiling);
            list.add(liBangCoat);
            list.add(dongPengTile);

            price = price.add(area.multiply(new BigDecimal("0.2"))).multiply(levelOneCeiling.price());
            price = price.add(area.multiply(new BigDecimal("1.4"))).multiply(liBangCoat.price());
            price = price.add(area.multiply(area.multiply(dongPengTile.price())));
        }

        StringBuilder detail = new StringBuilder("\r\n-----------------------------------\r\n"+
                "装修清单" + "\r\n" +
                "套餐等级：" + level + "\r\n" +
                "套餐价格：" + price.setScale(2, BigDecimal.ROUND_HALF_UP) +
                " 元\r\n" +
                "房屋⾯面积：" + area.doubleValue() + " 平⽶米\r\n" +
                "材料料清单：\r\n");

        for (Matter matter : list) {
            detail.append(matter.scene()).append("：").append(matter.brand()).append("、")
                    .append(matter.model()).append("、平米价格：").append(matter.price()).append("元。\n");
        }

        return detail.toString();
    }
}
