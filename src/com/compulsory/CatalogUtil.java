package com.compulsory;

import java.awt.*;
import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * This class is responsible with external operations regarding a catalog.
 */
public class CatalogUtil {

    /**
     * Saves a catalog into a file.
     * @param catalog
     * @throws IOException
     */
    public static void save(Catalog catalog) throws IOException {
        try (var oos = new ObjectOutputStream(new FileOutputStream(catalog.getPath()))) {
            oos.writeObject(catalog);
        }
    }

    /**
     * Loads a catalog from a file.
     * @param path The path to the file.
     * @return
     * @throws InvalidCatalogException
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static Catalog load(String path) throws InvalidCatalogException, IOException, ClassNotFoundException {
        try(var ois = new ObjectInputStream(new FileInputStream(path))) {
            return (Catalog) ois.readObject();
        }
    }

    /**
     * Opens a document using the native operating system application
     * @param doc
     * @throws URISyntaxException
     * @throws IOException
     */
    public static void view(Document doc) throws URISyntaxException, IOException {
        Desktop desktop = Desktop.getDesktop();
        // browse or open depending of the location type
        //https://stackoverflow.com/questions/25237682/how-to-know-whether-a-string-path-is-web-url-or-a-file-based
        URI uri = new URI(doc.getLocation());
        //check to see if the location of the document is a path in the local file system or a link to an external URL
        boolean isWeb = "http".equalsIgnoreCase(uri.getScheme()) || "https".equalsIgnoreCase(uri.getScheme());
        if(isWeb) {
            desktop.browse(uri); //open the document using the default browser
        } else {
            desktop.open(new File(doc.getLocation())); // open the document using the native app
        }
    }
}
