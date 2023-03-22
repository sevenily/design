package com.builder.factory;


/**
 * 装修包接口
 */
public interface Imenu {

    Imenu appendCeiling(Matter matter); // 吊顶

    Imenu appendCoat(Matter matter); // 涂料

    Imenu appengFloor(Matter matter); //地板

    Imenu appengTile(Matter matter); // 地砖

    String getDetail(); //明细
}
