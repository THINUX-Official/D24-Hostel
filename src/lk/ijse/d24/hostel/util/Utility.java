package lk.ijse.d24.hostel.util;

/*
    @author THINUX
    @created 06-Apr-23 - 10:06 
*/

import java.io.IOException;
import java.util.Properties;

public class Utility {
    public static Properties getProperties() {
        Properties properties = new Properties();
        try {
            properties.load(ClassLoader.getSystemClassLoader().getResourceAsStream("hibernate,properties"));

        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }
}
