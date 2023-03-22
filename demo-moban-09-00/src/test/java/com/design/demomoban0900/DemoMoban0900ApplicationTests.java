package com.design.demomoban0900;

import com.design.demomoban0900.group.DangDangNetMall;
import com.design.demomoban0900.group.JDNetMall;
import com.design.demomoban0900.group.TaoBaoNetMall;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoMoban0900ApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    public void test_NetJDMail(){
        NetMall netMall = new JDNetMall("100001", "1233155");
        String jd = netMall.generateGoodsPoster("https://item.jd.com/100008348542.html");
        System.out.println(jd);

    }

    @Test
    public void test_NetTBMail(){
        NetMall netMall = new TaoBaoNetMall("100001", "1233133");
        String tb = netMall.generateGoodsPoster("https://detail.tmall.com/item.html");
        System.out.println(tb);

    }

    @Test
    public void test_NetDDMail(){
        NetMall netMall = new DangDangNetMall("100001", "1231313");
        String dd = netMall.generateGoodsPoster("http://product.dangdang.com/1509704171.html");
        System.out.println(dd);

    }
}
