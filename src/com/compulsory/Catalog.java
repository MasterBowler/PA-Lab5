package com.compulsory;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * A catalog of documents. It is described by a name and its path on the local device
 */
public class Catalog implements Serializable {
    private String name;
    private String path;
    private List<Document> documents = new ArrayList<>();

    /**
     * Create a catalog
     * @param name name of the catalog
     * @param path location on the local device
     */
    public Catalog(String name, String path) {
        this.name = name;
        this.path = path;
    }

    /**
     * add a document to the catalog
     * @param doc
     */
    public void add(Document doc) {
        documents.add(doc);
    }

    /**
     * Searches for a document in the catalog by its id.
     * @param id The id of the document to search for
     * @return Returns the document or null if no matches are found.
     */
    public Document findById(String id) {
        return documents.stream().filter(d -> d.getId().equals(id)).findFirst().orElse(null);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public List<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(List<Document> documents) {
        this.documents = documents;
    }
}
