package com.company.xml.dom4j;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.util.List;

public class TestDom4j {
    @Test
    public void testReaderWebXML() {
        try {
//        获取解析器
            SAXReader saxReader = new SAXReader();
//        获取Document文档对象
            Document doc = saxReader.read("src\\com\\company\\xml\\schema\\web");
//        获取根元素
            Element rootEle = doc.getRootElement();
            //
//            System.out.println(rootEle.getName());
            System.out.println(rootEle.attributeValue("version"));
//            获取根元素下的子元素
            List<Element> childElements = rootEle.elements();
//            遍历子元素
            for (Element element : childElements) {
//                判断元素名称为servlet的元素
                if ("servlet".equals(element.getName())) {
                    Element servletName = element.element("servlet-name");
                    Element servletClass = element.element("servlet-class");
                    System.out.println(servletName.getText());
                    System.out.println(servletClass.getText());
                }
            }

        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

}
