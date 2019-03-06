package com.company.web.servlet1;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import static org.junit.Assert.*;

public class MyServlet1Test {
    @Test
    public void testMyServlet1(){
        try {
//        创建解析器对象
            SAXReader saxReader = new SAXReader();
//        加载web.xml文件
            Document doc = saxReader.read("src\\com\\company\\web\\servlet1\\web");
//        获取根元素节点
            Element rootEle = doc.getRootElement();
//        获取servler元素
            Element servletEle = rootEle.element("servlet");
//            根据元素名获取servler-class文本节点
            String servletClass = servletEle.element("servlet-class").getText();
            System.out.println(servletClass);
//            通过类全名获取字节码文件
            Class clazz = Class.forName(servletClass);
            MyServlet1 my = (MyServlet1) clazz.newInstance();
            my.init();
            my.service();
            my.destroy();
        } catch (DocumentException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }

    }

}