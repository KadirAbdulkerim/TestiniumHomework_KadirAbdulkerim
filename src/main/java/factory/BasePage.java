package factory;

import org.openqa.selenium.WebDriver;

/**
 * @author Kadirdan Abdukerim
 * @create 2022-10-08-12:38 PM
 */
public abstract class BasePage {
    public abstract WebDriver init_driver(String browser);
}
