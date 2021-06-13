package util;

import java.util.ResourceBundle;

public class PropertyLoader {
    private final static ResourceBundle RESOURCE = ResourceBundle.getBundle("config");

    public static String loadProperty(String name) {
        return RESOURCE.getString(name);
    }
}
