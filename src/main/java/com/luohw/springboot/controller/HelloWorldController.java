package com.luohw.springboot.controller;

import com.alibaba.fastjson.JSON;
import com.luohw.springboot.domain.NeoProperties;
import com.luohw.springboot.mapper.GuidanceEvaluationListMapper;
import com.luohw.springboot.service.GuidanceService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.JedisCluster;

/**
 * springboot启动后测试类，用于看看页面出来了没
 * Created by luohw on 2018/5/2 0002.
 */

//该注解需要引入 spring-boot-starter-web
@RestController
public class HelloWorldController {
    private static Logger logger = LogManager.getLogger("springbootlogger");

    @Autowired
    NeoProperties neoProperties;
//    @Autowired
//    JedisCluster jedisCluster;


    /**
     * 只是为了测试服务，看能否读取配置
     * @return
     */
    @RequestMapping("/hello")
    public String index(){
        //输出property文件的内容
//        System.out.println(neoProperties.getTitle());
//        System.out.println(neoProperties.getDescription());
//        jedisCluster.set("springboot-jedis","123456");
//        System.out.println(jedisCluster.get("springboot-jedis"));
//        System.out.println(JSON.toJSONString(guidanceEvaluationListMapper.getOne(3L)));

        return neoProperties.getTitle()+"   "+neoProperties.getDescription();


    }
}
