package com.epam.framework.core.utils;


import java.io.InputStream;
import java.net.URL;

public class FileUtils {

    static public String getResourcePath(String fileName) {
        ClassLoader classLoader = (new FileUtils()).getClass().getClassLoader();
        URL url = classLoader.getResource(fileName);
        return url.getPath();
    }

    static public InputStream getResourcePathAsImputStream(String fileName) {
        ClassLoader classLoader = (new FileUtils()).getClass().getClassLoader();
        InputStream stream = classLoader.getResourceAsStream(fileName);
        return stream;
    }
}
