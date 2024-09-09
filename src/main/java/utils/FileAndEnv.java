package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class FileAndEnv {

    public static Map<String, String> fileAndEnv;
    public static Properties propMain;
    public static FileInputStream propertyFile;

    public static Map<String, String> getConfigProperty(){

        String env = System.getProperty("env");
        fileAndEnv = new HashMap<>();
        propMain = new Properties();


            try {
                propertyFile = new FileInputStream("src/main/resources/dev/server.properties");
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
        }

        try {
            propMain.load(propertyFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        fileAndEnv.put("serverName", propMain.getProperty("serverName"));
        fileAndEnv.put("port", propMain.getProperty("port"));

        return fileAndEnv;
    }
}
