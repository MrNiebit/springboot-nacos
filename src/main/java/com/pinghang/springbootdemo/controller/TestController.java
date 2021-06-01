/**
 * @(#)TestController.java, 6月 01, 2021.
 * <p>
 * Copyright 2021 pinghang.com. All rights reserved.
 * PINGHANG.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.pinghang.springbootdemo.controller;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <h2></h2>
 * @author niebaohua
 * date 2021/6/1
 */
@RestController
public class TestController {

    /*
    * autoRefreshed: true ==> 在nacos上修改后，实时更新
    * false 时，如果修改了内容，需要服务重启 才能更新
    * */

    @NacosValue(value = "${useLocalCache:false}", autoRefreshed = true)
    private boolean useLocalCache;

    @NacosValue(value = "${nacos.param.content:null}", autoRefreshed = false)
    private String content;

    @RequestMapping("/a")
    public String a () {
        return "hello a ..., and useLocalCache is ===>> " + useLocalCache;
    }

    @RequestMapping("/b")
    public String b () {
        return content;
    }

}
