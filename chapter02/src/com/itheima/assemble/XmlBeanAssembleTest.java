package com.itheima.assemble;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class XmlBeanAssembleTest {
    public static void main(String[] args) {
        String xmlPath = "com/itheima/assemble/beans5.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);

//        构造方式输出
        System.out.println(applicationContext.getBean("user1"));
//    设值方式输出
        System.out.println(applicationContext.getBean("user2"));
    }
}
