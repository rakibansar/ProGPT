package UtilityProgpt;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyProgpt {
    
    // URL
    public static String progptStaging;
    public static String progptProd;

    public static void readdata() throws IOException {        
        Properties url = new Properties();

        // Corrected: using the class loader of the class
        InputStream urlInput = PropertyProgpt.class.getClassLoader()
                .getResourceAsStream("UtilityresourceProgpt/URLprogpt.properties");

        if (urlInput == null) {
            throw new FileNotFoundException("Property file 'URLprogpt.properties' not found in classpath");
        }

        url.load(urlInput);

        progptStaging = url.getProperty("progptStaging");
        progptProd = url.getProperty("progptProd");
    }
}