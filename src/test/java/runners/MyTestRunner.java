package runners;

/**
 * @author Kadirdan Abdukerim
 * @create 2022-10-06-8:24 PM
 */

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        monochrome = true,
        plugin = {"pretty", "html:Test_Result/RegressionTest.html"},
        features = {"src/test/resources/features"},
        glue = {"stepdefinitions","apphooks"},
        tags = "@Test")
public class MyTestRunner {
}
