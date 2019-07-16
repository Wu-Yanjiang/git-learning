package com.itheima.instance.static_factory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class InstanceTest2 {
//    使用自定义工厂方法实例化Bean
    public static void main(String[] args) {
        String xmlPath = "com/itheima/instance/static_factory/beans2.xml";
//        加载配置文件时对bean实例化
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
        System.out.println(applicationContext.getBean("bean2"));
    }
}
