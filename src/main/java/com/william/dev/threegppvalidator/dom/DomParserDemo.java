package com.william.dev.threegppvalidator.dom;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

/**
 * Created by william on 19/03/18.
 */
public class DomParserDemo {
    public static void main(String[] args) {
        long beforeUsedMem = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        Long start = System.currentTimeMillis();
        try {
            Document document = getXmlTree();
            findTagInXmlTree("TargetPoint", document);
            findTagInXmlTree("InstrumentPoint", document);
            findTagInXmlTree("CoordGeom", document);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Time : " + (System.currentTimeMillis() - start) + " ms");
        long afterUsedMem = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        System.out.println("Memory used: " + (afterUsedMem - beforeUsedMem));
    }

    private static Document getXmlTree() throws ParserConfigurationException, SAXException, IOException {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        File inputFile = new File(classLoader.getResource("1611000A.xml").getFile());
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.parse(inputFile);
        document.getDocumentElement().normalize();
        return document;
    }

    private static void findTagInXmlTree(String tagName, Document document) {
        NodeList nodeList = document.getElementsByTagName(tagName);
        if (nodeList.getLength() > 0) {
            System.out.println("'" + tagName + "' tag found in file");
        } else {
            System.out.println("'" + tagName + "' tag not found in file");
        }
    }
}
