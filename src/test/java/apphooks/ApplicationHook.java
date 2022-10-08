package apphooks;

import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import pageutility.ConfigReader;
import pageutility.Log4j;
import pageutility.Screenshot;

import java.util.Properties;

/**
 * @author Kadirdan Abdukerim
 * @create 2022-10-06-10:38 PM
 */
public class ApplicationHook {

    private WebDriver driver;
    private DriverFactory driverFactory;
    private ConfigReader configReader;
    Properties prop;

    @Before(order = 0)
    public void getProperty() {
        configReader = new ConfigReader();
        prop = configReader.init_prop();
    }

    @Before(order = 1)
    public void launchBrowser() {
        String browserName = prop.getProperty("browser");
        driverFactory = new DriverFactory();
        driver = driverFactory.init_driver(browserName);
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            Log4j.error(scenario.getName() + "      Failed");
            Screenshot screenshot = new Screenshot();
            screenshot.takeScreenshot("image", scenario.getName(), driver);
            byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(sourcePath, "image/png", scenario.getName());
        }
        if (!scenario.isFailed()) {
            Log4j.info(scenario.getName() + "       Passed");
        }
        driver.quit();
    }
}
