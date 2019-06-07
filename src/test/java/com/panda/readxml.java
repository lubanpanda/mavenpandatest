package com.panda;
import org.dom4j.io.SAXReader;
import java.io.File;
import org.dom4j.Element;


import java.util.Iterator;
import java.util.List;

public class readxml {

    public static void main(String[] args) {

        // TODO Auto-generated method stub
        File file=new File("/Users/panda/Desktop/test.xml");
        SAXReader reader=new SAXReader();
        org.dom4j.Document doc=null;
        try {
            doc=reader.read(file);

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        assert doc != null;
        Element root=doc.getRootElement();
        Iterator it=root.elementIterator();
        while(it.hasNext()) {
            System.out.println("=====开始第一次便利=====");
            Element book = (Element) it.next();
            // 获取book的属性名以及 属性值
            List<org.dom4j.Attribute> bookAttrs = book.attributes();
            for (org.dom4j.Attribute attr : bookAttrs) {
                System.out.println("属性名：" + attr.getName() + "--属性值："
                        + attr.getValue());
            }
            Iterator itt = book.elementIterator();
            while (itt.hasNext()) {
                Element bookChild = (Element) itt.next();
                System.out.println("节点名：" + bookChild.getName() + "--节点值：" + bookChild.getStringValue());
            }
            System.out.println("==========");
            System.out.println("hello word");
        }
    }
}
