# Spring Boot Nacos 配置 demo


## 下载启动nacos window版

nacos下载地址：[https://github.com/alibaba/nacos/releases/download/2.0.1/nacos-server-2.0.1.zip](https://github.com/alibaba/nacos/releases/download/2.0.1/nacos-server-2.0.1.zip)

解压后启动
单机启动
```bash
startup.cmd -m standalone
```

## 配置nacos

![](https://ftp.bmp.ovh/imgs/2021/06/c1236056523aeb5d.png)

![](https://ftp.bmp.ovh/imgs/2021/06/ea2ae1815f7521cb.png)

## 启动 spring boot

```java
    /*
    * autoRefreshed: true ==> 在nacos上修改后，实时更新
    * false 时，如果修改了内容，需要服务重启 才能更新
    * */

    @NacosValue(value = "${useLocalCache:false}", autoRefreshed = true)
    private boolean useLocalCache;

    @NacosValue(value = "${nacos.param.content:null}", autoRefreshed = false)
    private String content;
```
启动类增加 该注解 `@NacosPropertySource(dataId = "example", autoRefreshed = true)`
example 为 dataId