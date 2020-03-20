package com.compulsory;

import java.io.IOException;
import java.net.URISyntaxException;

//https://profs.info.uaic.ro/~acf/java/labs/slides/lab_05.pdf

public class Main {

    public static void main(String args[]) {
        Main app = new Main();
        app.testCreateSave();
        app.testLoadView();
    }

    private void testCreateSave() {
        Catalog catalog = new Catalog("Java Resources", "D:/java/catalog.ser");
        Document doc = new Document("java1", "Java Course 1", "https://profs.info.uaic.ro/~acf/java/slides/en/intro_slide_en.pdf");
        doc.addTag("type", "Slides");
        catalog.add(doc);

        try {
            CatalogUtil.save(catalog);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void testLoadView() {
        Catalog catalog = null;
        try {
            catalog = CatalogUtil.load("D:/java/catalog.ser");
        } catch (InvalidCatalogException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Document doc = catalog.findById("java1");
        try {
            CatalogUtil.view(doc);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
