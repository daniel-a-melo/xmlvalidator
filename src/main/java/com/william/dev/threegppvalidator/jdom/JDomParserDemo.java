package com.william.dev.threegppvalidator.jdom;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

import java.io.File;
import java.util.List;

/**
 * Created by william on 24/03/18.
 */
public class JDomParserDemo {

    public static void main(String[] args) {
        long beforeUsedMem = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        Long start = System.currentTimeMillis();

        try {
            ClassLoader classLoader = ClassLoader.getSystemClassLoader();
            File inputFile = new File(classLoader.getResource("1611000A.xml").getFile());

            SAXBuilder saxBuilder = new SAXBuilder();
            Document document = saxBuilder.build(inputFile);
            Element classElement = document.getRootElement();

            List<Element> dataNodes = classElement.getChildren();
            for (Element dataNode : dataNodes) {
                List<Element> children = dataNode.getChildren();
                for (Element child : children) {
                    System.out.println(child.getName());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Time : " + (System.currentTimeMillis() - start) + " ms");
        long afterUsedMem = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        System.out.println("Memory used: " + (afterUsedMem - beforeUsedMem));
    }
}
