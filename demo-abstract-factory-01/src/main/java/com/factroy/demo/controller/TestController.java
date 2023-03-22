package com.factroy.demo.controller;

import com.factroy.demo.factory.impl.EGMCacheAdapter;
import com.factroy.demo.factory.impl.IIRCacheAdapter;
import com.factroy.demo.factory.impl.JDKProxy;
import com.factroy.demo.service.ICacheService;
import com.factroy.demo.service.impl.CacheServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Api(tags = "抽象工厂测试类")
public class TestController {

    @ApiOperation(value = "testEGMCacheService", notes = "EGM抽象工厂测试")
    @GetMapping("testEGMCacheService")
    public String cacheEGMCService() throws Exception {
        ICacheService proxy_EGM = JDKProxy.getProxy(CacheServiceImpl.class, new EGMCacheAdapter());
        proxy_EGM.set("proxy_EGM", "GGM");
        return proxy_EGM.get("proxy_EGM");
    }

    @ApiOperation(value = "testIIRCacheService", notes = "IIR抽象工厂测试")
    @GetMapping("testIIRCacheService")
    public String cacheIIRService() throws Exception {
        ICacheService proxy_IIR = JDKProxy.getProxy(CacheServiceImpl.class, new IIRCacheAdapter());
        proxy_IIR.set("proxy_IIR", "IIR");
        return proxy_IIR.get("proxy_IIR");
    }
}
