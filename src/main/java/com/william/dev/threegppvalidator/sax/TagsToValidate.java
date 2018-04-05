package com.william.dev.threegppvalidator.sax;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by william on 20/03/18.
 */
public class TagsToValidate {

    private Map<String, Boolean> tagValidateResults = new HashMap<String, Boolean>();

    public TagsToValidate(String... tags) {
        for (String tag : tags) {
            tagValidateResults.put(tag, false);
        }
    }

    public void checkTag(String tag) {
        if (tagValidateResults.containsKey(tag)) {
            tagValidateResults.put(tag, true);
        }
    }

    public Map<String, Boolean> getTagValidateResults() {
        return tagValidateResults;
    }

}
