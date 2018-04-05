package com.william.dev.threegppvalidator.sax;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.util.Map;

/**
 * Created by william on 19/03/18.
 */
public class SAXParserDemo {

    public static void main(String[] args) {
        long beforeUsedMem = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        Long start = System.currentTimeMillis();
        try {
            ClassLoader classLoader = ClassLoader.getSystemClassLoader();
            File inputFile = new File(classLoader.getResource("1611000A.xml").getFile());
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();

            DataHandler dataHandler = new DataHandler();
            TagsToValidate tagsToValidate = new TagsToValidate("CoordGeom", "InstrumentPoint", "TargetPoint");
            dataHandler.setTagsToValidate(tagsToValidate);
            saxParser.parse(inputFile, dataHandler);

            Map<String, Boolean> tagValidateResults = tagsToValidate.getTagValidateResults();
            assertAllTagsFound(tagValidateResults);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Time : " + (System.currentTimeMillis() - start) + " ms");
        long afterUsedMem = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        System.out.println("Memory used: " + (afterUsedMem - beforeUsedMem));
    }

    private static void assertAllTagsFound(Map<String, Boolean> tagSearchResults) {
        for (Map.Entry<String, Boolean> tag : tagSearchResults.entrySet()) {
            String tagName = tag.getKey();
            boolean tagFound = tag.getValue();
            if (tagFound) {
                System.out.println("'" + tagName + "' tag found in file");
            } else {
                System.out.println("'" + tagName + "' tag not found in file");
            }
        }
    }
}
