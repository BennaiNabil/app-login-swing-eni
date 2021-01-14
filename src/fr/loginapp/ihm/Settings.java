package fr.loginapp.ihm;

import java.util.Properties;

public class Settings {
    private static Properties properties;

    static {
        try {
            properties = new Properties();
            properties.load(Settings.class.getResourceAsStream("login.properties"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key, null);
    }

}
