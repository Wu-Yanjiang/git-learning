package com.itheima.instance.constructor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class InstanceTest1 {
    public static void main(String[] args) {
        //构造器实例化
        String xmlPath = "com/itheima/instance/constructor/spring-config.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
        Bean1 bean = (Bean1)applicationContext.getBean("bean1");
        System.out.println(bean);

//        定义配置文件路径
//        Spring容器ApplicationContext加载配置文件
//        Spring容器通过id来实现Bean类的默认无参构造方法
    }
}


