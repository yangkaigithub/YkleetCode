import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.DOMReader;
import org.dom4j.io.SAXReader;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class DomText {

    public static void main(String[] args) throws DocumentException, ParserConfigurationException, IOException, SAXException {
        SAXReader saxReader = new SAXReader();

        Document document = saxReader.read(new File("db-config.xml"));

        // 获取根元素
        Element root = document.getRootElement();
        System.out.println("Root: " + root.getName());

        // 获取所有子元素
        List<Element> childList = root.elements();
        System.out.println("total child count: " + childList.size());

        // 获取特定名称的子元素
        List<Element> list1 = root.elements("vision.apollo.publicservice.module.dict.domain.DataDictType");
//        System.out.println("hello child: " + childList2.size());
        List<Element> list2 = root.elements("vision.apollo.publicservice.module.dict.domain.DataDict");
        for(Element type:list1){
            System.out.println(type.attributeValue("caption"));
            for(Element dict:list2){
                if(dict.attributeValue("typeCode") .equals(type.attributeValue("code")) ){
                    System.out.println("\t"+dict.attributeValue("name"));
                }
            }
            System.out.println();
        }

    }
}
