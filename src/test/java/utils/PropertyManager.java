package utils;

import java.io.InputStream;
import java.util.Properties;

public class PropertyManager {

    private static PropertyManager instance;

    private String baseUrl;

    public static PropertyManager getInstance() {
        if(instance == null) {
            instance = new PropertyManager();
            instance.loadProperties();
        }
        return instance;
    }

    private void loadProperties() {
        Properties properties = new Properties();

        try {
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream("application.properties");
            properties.load(inputStream);
            inputStream.close();
        }catch (Exception e) {
            System.out.println("Failed to load properties file");
            e.printStackTrace();
        }

        this.baseUrl = properties.getProperty("baseUrl");
    }

    public String getBaseUrl() {
         return baseUrl;
    }
}
