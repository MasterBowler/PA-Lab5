package com.compulsory;

import java.awt.*;
import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;

/**
 *
 */
public class CatalogUtil {

    public static void save(Catalog catalog) throws IOException {
        try (var oos = new ObjectOutputStream(new FileOutputStream(catalog.getPath()))) {
            oos.writeObject(catalog);
        }
    }

    public static Catalog load(String path) throws InvalidCatalogException, IOException, ClassNotFoundException {
        try(var ois = new ObjectInputStream(new FileInputStream(path))) {
            return (Catalog) ois.readObject();
        }
    }

    public static void view(Document doc) throws URISyntaxException, IOException {
        Desktop desktop = Desktop.getDesktop();
        // browse or open depending of the location type
        //https://stackoverflow.com/questions/25237682/how-to-know-whether-a-string-path-is-web-url-or-a-file-based
        URI uri = new URI(doc.getLocation());
        boolean isWeb = "http".equalsIgnoreCase(uri.getScheme()) || "https".equalsIgnoreCase(uri.getScheme());
        if(isWeb) {
            desktop.browse(uri);
        } else {
            desktop.open(new File(doc.getLocation()));
        }
    }
}
