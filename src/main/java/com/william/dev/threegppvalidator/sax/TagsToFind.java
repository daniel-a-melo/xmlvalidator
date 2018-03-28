package com.william.dev.threegppvalidator.sax;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by william on 20/03/18.
 */
public class TagsToFind {

    private Map<String, Boolean> tagSearchResults = new HashMap<String, Boolean>();

    public TagsToFind(String... tags) {
        for (String tag : tags) {
            tagSearchResults.put(tag, false);
        }
    }

    public void checkTag(String tag) {
        if (tagSearchResults.containsKey(tag)) {
            tagSearchResults.put(tag, true);
        }
    }

    public Map<String, Boolean> getTagSearchResults() {
        return tagSearchResults;
    }

}
