package com.itheima.scope;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ScopeTest {
    public static void main(String[] args) {
        String xmlPath = "com/itheima/scope/beans4.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
//        输出获得实例
        System.out.println(applicationContext.getBean("scope"));
        System.out.println(applicationContext.getBean("scope"));
    }
}
