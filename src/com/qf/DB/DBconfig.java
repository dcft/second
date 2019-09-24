package com.qf.DB;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DBconfig {
    static Properties pro = new Properties();
    static {
        InputStream is= DBconfig.class.getClassLoader().getResourceAsStream("db.properties");
        try {
            pro.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getValue(String key){
        return pro.getProperty(key);
    }
}
