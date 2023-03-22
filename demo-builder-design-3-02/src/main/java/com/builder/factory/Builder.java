package com.builder.factory;

import com.builder.factory.ceilling.LevelOneCeiling;
import com.builder.factory.ceilling.LevelTwoCeiling;
import com.builder.factory.coat.DuluxCoat;
import com.builder.factory.coat.LiBangCoat;
import com.builder.factory.floor.ShengXiangFloor;
import com.builder.factory.tile.DongPengTile;
import com.builder.factory.tile.MarcoPoloTile;

import java.math.BigDecimal;

/**
 * 建造者具体的各种组装由此类实现
 */
public class Builder {
    public Imenu levelOne(BigDecimal area, int grade){
        return new DecorationPackageMenu(area, grade)
                .appendCeiling(new LevelOneCeiling())
                .appendCoat(new DuluxCoat())
                .appengFloor(new ShengXiangFloor());
    }

    public Imenu levelTwo(BigDecimal area, int grade){
        return new DecorationPackageMenu(area, grade)
                .appendCeiling(new LevelTwoCeiling())
                .appendCoat(new LiBangCoat())
                .appengFloor(new MarcoPoloTile());
    }

    public Imenu levelThree(BigDecimal area, int grade){
        return new DecorationPackageMenu(area, grade)
                .appendCeiling(new LevelOneCeiling())
                .appendCoat(new LiBangCoat())
                .appengFloor(new DongPengTile());
    }

}
