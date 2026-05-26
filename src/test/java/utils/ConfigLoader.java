package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

    public class ConfigLoader {

        private static Properties properties;

        static {

            try {

                FileInputStream file =
                        new FileInputStream("C:\\Users\\USER\\Downloads\\demo\\ThinkAndGetIt-Api-Automation\\src\\test\\resources\\Config.properties");

                properties = new Properties();

                properties.load(file);

            } catch (IOException e) {

                throw new RuntimeException(
                        "Failed to load config.properties"
                );
            }
        }

        public static String getBaseUrl() {

            return properties.getProperty("base.url");

        }
        public static String getAdminEmail(){
            return properties.getProperty("admin.email");

        }
        public static String getPassword(){
            return properties.getProperty("admin.password");

        }

    }

