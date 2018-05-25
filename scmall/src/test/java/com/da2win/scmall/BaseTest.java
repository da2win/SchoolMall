package com.da2win.scmall;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 配置spring 和 unit 整合, junit启动时加载springioc容器
 */
@RunWith(SpringJUnit4ClassRunner.class)
// spring配置文件地址
@ContextConfiguration({"classpath:spring/spring-dao.xml","classpath:spring/spring-service.xml",})
public class BaseTest {


}
