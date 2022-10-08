package pageutility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @author Kadirdan Abdukerim
 * @create 2022-10-06-8:14 PM
 */
public class ConfigReader {

    public Properties init_prop() {
        Properties prop = new Properties();
        try {
            FileInputStream ip = new FileInputStream("config.properties");
            prop.load(ip);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop;
    }
}
