package com.luohw.springboot.controller;

import com.alibaba.fastjson.JSON;
import com.luohw.springboot.domain.NeoProperties;
import com.luohw.springboot.domain.OrderDTO;
import com.luohw.springboot.domain.User;
import com.luohw.springboot.mapper.GuidanceEvaluationListMapper;
import com.luohw.springboot.service.GuidanceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import redis.clients.jedis.JedisCluster;

import javax.servlet.http.HttpServletRequest;

/**
 * springboot启动后测试类，用于看看页面出来了没
 * Created by luohw on 2018/5/2 0002.
 */

//该注解需要引入 spring-boot-starter-web
@Api(description = "HelloWorld接口")
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
    @ApiOperation(value="测试springboot输出", notes="这是描述")
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String index(){
        //输出property文件的内容
//        System.out.println(neoProperties.getTitle());
//        System.out.println(neoProperties.getDescription());
//        jedisCluster.set("springboot-jedis","123456");
//        System.out.println(jedisCluster.get("springboot-jedis"));
//        System.out.println(JSON.toJSONString(guidanceEvaluationListMapper.getOne(3L)));

        return neoProperties.getTitle()+"   "+neoProperties.getDescription();
    }



    @ApiOperation(value="输出某个用户说hello",
            notes="{\n" +
                    "  \"age\": 100,\n" +
                    "  \"userName\": \"zhangsan\"\n" +
                    "}")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "user", value = "用户对象", required = true, dataType = "User")
    })
    @RequestMapping(value = "/sayhello",method = RequestMethod.POST)
    public String sayHello(@RequestBody User user){
        return user.getAge()+" 岁的 "+user.getUserName()+" say hello";
    }


    @ApiOperation(value="根据订单id获取订单信息")
    @ApiImplicitParam(name = "orderId", value = "订单id", required = true, dataType = "Integer")
    @RequestMapping(value = "/order",method = RequestMethod.GET)
    @ResponseBody
    public OrderDTO getOrder(Integer orderId){
        OrderDTO orderDTO=new OrderDTO();
        orderDTO.setOrderId(orderId);
        orderDTO.setGoodsId(10086);
        orderDTO.setGoodsName("移动58话费套餐");
        orderDTO.setPrice(5800);
        orderDTO.setUserName("张三");
        return orderDTO;
    }
}
