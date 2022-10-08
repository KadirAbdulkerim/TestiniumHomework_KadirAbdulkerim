package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import pageutility.Utility;

/**
 * @author Kadirdan Abdukerim
 * @create 2022-10-06-4:53 PM
 */
public class HomePage {

    private WebDriver driver;
    public String searchedItemName;

    private By searchBox = By.cssSelector("input[placeholder='Ürün, Marka Arayın']");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterItemInSearchBox(int index) {
        searchedItemName = Utility.getColumn(index - 1);
        driver.findElement(searchBox).sendKeys(searchedItemName);
    }

    public void clearTheFirstInput() {
        driver.findElement(searchBox).sendKeys(Keys.CONTROL + "a");
        driver.findElement(searchBox).sendKeys(Keys.DELETE);
    }

    public void pressEnter() {
        driver.findElement(searchBox).sendKeys(Keys.ENTER);
    }
}
