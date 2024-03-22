package com.seleniumframework.core;

import lombok.Getter;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Utility class for loading properties from a configuration file.
 * @author Kamalesh
 * @version 1.0
 */
public class PropertiesUtils {
    /**
     * Properties instance containing the loaded properties.
     */
    @Getter
    private static final Properties properties = new Properties();
    /**
     * Constructor for PropertiesUtils class. Loads properties from the configuration file.
     */
    public PropertiesUtils(){
        try(FileInputStream fi = new FileInputStream("./config/config.properties")) {
            setProperties(fi);
        }catch (IOException io){
            io.getStackTrace();
        }

    }
    /**
     * Sets the properties using the given input stream.
     *
     * @param fi FileInputStream to load properties from.
     */
    public static void setProperties(FileInputStream fi){
        try {
            properties.load(fi);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


}
