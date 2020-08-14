package main.mclorencia.config;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigUtil {

    Properties properties;

    public ConfigUtil() {
        try {
            FileReader fileReader = new FileReader("config.properties");
            properties = new Properties();
            properties.load(fileReader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Properties getProperties() {
        return properties;
    }
}
