package com.builder.factory;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * 装修包实现
 */
public class DecorationPackageMenu implements Imenu{
    private List<Matter> list = new ArrayList<Matter>();    //装修清单
    private BigDecimal price = BigDecimal.ZERO;     //装修价格
    private BigDecimal area; //面积
    private int grade;   //装修等级：豪华欧式、轻奢田园、现代简约

    public DecorationPackageMenu() {
    }

    public DecorationPackageMenu(BigDecimal area, int grade) {
        this.area = area;
        this.grade = grade;
    }

    @Override
    public Imenu appendCeiling(Matter matter) {
        list.add(matter);
        price = price.add(area.multiply(new BigDecimal("0.2")).multiply(matter.price()));
        return this;
    }

    @Override
    public Imenu appendCoat(Matter matter) {
        list.add(matter);
        price = price.add(area.multiply(new BigDecimal("1.4")).multiply(matter.price()));
        return this;
    }

    @Override
    public Imenu appengFloor(Matter matter) {
        list.add(matter);
        price = price.add(area.multiply(matter.price()));
        return this;
    }

    @Override
    public Imenu appengTile(Matter matter) {
        list.add(matter);
        price = price.add(area.multiply(matter.price()));
        return this;
    }

    @Override
    public String getDetail() {
        StringBuilder detail = new StringBuilder("\r\n-----------------------------------\r\n"+
                "装修清单" + "\r\n" +
                "套餐等级：" + grade + "\r\n" +
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
