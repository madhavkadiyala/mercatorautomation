package helpers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import static java.lang.System.out;

public class Props {
    private static final Logger LOG = LoggerFactory.getLogger(Props.class);
     private static Properties properties;
    private static final String RUN_CONFIG_PROPERTIES = "/environment.properties";

    /**
     * Gets the key from config.properties
     *
     * @param key key from props
     **/

    public static String getConfigProperty(String key) {
        if ((key == null) || key.isEmpty()) {
            return "";
        } else {
            return properties.getProperty(key);
        }
    }

    public static void loadRunConfigProps() {
              properties = new Properties();
        try (InputStream inputStream = Props.class.getResourceAsStream(RUN_CONFIG_PROPERTIES)) {
            properties.load(inputStream);
            properties.list(out);
        } catch (IOException e) {
            LOG.error(e.getMessage());
        }
    }
}


