package com.william.dev.threegppvalidator.sax;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * Created by william on 19/03/18.
 */
public class DataHandler extends DefaultHandler {
    private TagsToValidate tagsToValidate;

    public void setTagsToValidate(TagsToValidate tagsToValidate) {
        this.tagsToValidate = tagsToValidate;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        tagsToValidate.checkTag(qName);
    }
}
