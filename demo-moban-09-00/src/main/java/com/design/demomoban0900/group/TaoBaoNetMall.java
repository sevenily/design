package com.design.demomoban0900.group;

import com.alibaba.fastjson2.JSON;
import com.design.demomoban0900.HttpClient;
import com.design.demomoban0900.NetMall;
import sun.misc.BASE64Encoder;

import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaoBaoNetMall extends NetMall {
    public TaoBaoNetMall(String uId, String uPwd) {
        super(uId, uPwd);
    }

    @Override
    protected Boolean login(String uId, String uPwd) {
        logger.info("模拟淘宝用户登录 uId : {} uPwd: {}", uId, uPwd);
        return true;
    }

    @Override
    protected Map<String, String> reptile(String skuUrl) {
        String str = HttpClient.doGet(skuUrl);
        //截取title后的信息
        Pattern p9 = Pattern.compile("(?<=title\\>).*(?=</title)");
        Matcher matcher = p9.matcher(str);
        Map<String, String> map = new ConcurrentHashMap<>();
        if (matcher.find()){
            map.put("name", matcher.group());
        }
        map.put("price", "3777.00");
        logger.info("模拟淘宝商品爬虫解析：{} | {} 元 {}", map.get("name"), map.get("price"), skuUrl);
        return map;
    }

    @Override
    protected String createBase64(Map<String, String> goodsInfo) {
        BASE64Encoder encoder = new BASE64Encoder();
        logger.info("模拟生成淘宝商品Base64 海报");
        return encoder.encode(JSON.toJSONString(goodsInfo).getBytes(StandardCharsets.UTF_8));
    }
}
