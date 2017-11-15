package com.epam.framework.core.utils;

import java.io.File;

public class FileUtils {
    private File getFile(String resourceName) {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(resourceName).getFile());
        return file;
    }

    public static String getResourcePath(String resourceName){
        FileUtils fIleUtils = new FileUtils();
        return fIleUtils.getFile(resourceName).getAbsolutePath();
    }
}
