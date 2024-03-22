package com.seleniumframework.core;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class PropertiesUtils {
    public static Properties properties = new Properties();

    /**
     * @param filepath
     * filepath for the config properties.
     */
    public PropertiesUtils(){
        try(FileInputStream fi = new FileInputStream(new File(".\\config\\config.properties"))){
            properties.load(fi);
        }catch (IOException io){
            io.getStackTrace();
        }
    }

}
