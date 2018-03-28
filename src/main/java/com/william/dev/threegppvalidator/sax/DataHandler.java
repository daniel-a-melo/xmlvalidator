package com.william.dev.threegppvalidator.sax;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * Created by william on 19/03/18.
 */
public class DataHandler extends DefaultHandler {
    private TagsToFind tagsToFind;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)
            throws SAXException {
        tagsToFind.checkTag(qName);
    }

    public void setTagsToFind(TagsToFind tagsToFind) {
        this.tagsToFind = tagsToFind;
    }
}
