package com.compulsory;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * A document is uniquely identified by its id.
 * It has a name, a location(a path on the local device or an URL) and user defined tags.
 */
public class Document implements Serializable {

    private String id;
    private String name;
    private String location;

    /**
     * Creates a document
     * @param id unique id
     * @param name name of the document
     * @param location path or URL
     */
    public Document(String id, String name, String location) {
        this.id = id;
        this.name = name;
        this.location = location;
    }

    private Map<String, Object> tags = new HashMap<>();

    /**
     * add a new tag to the document
     * @param key
     * @param obj
     */
    public void addTag(String key, Object obj) {
        tags.put(key,obj);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Map<String, Object> getTags() {
        return tags;
    }

    public void setTags(Map<String, Object> tags) {
        this.tags = tags;
    }
}
