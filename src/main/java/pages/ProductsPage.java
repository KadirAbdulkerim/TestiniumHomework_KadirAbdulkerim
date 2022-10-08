package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageutility.Utility;

import java.io.IOException;

/**
 * @author Kadirdan Abdukerim
 * @create 2022-10-06-4:57 PM
 */
public class ProductsPage {

    private WebDriver driver;
    public static String selectedItemInfo;

    private By itemName = By.cssSelector("div[id='productListTitle'] b");

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getPageName() {
        return driver.findElement(itemName).getText();
    }

    public void selectAProductRandomly() {
        WebElement selectedItem = Utility.randomSelect(".row.o-productList__container>.col-sm-4.col-md-4.col-lg-4.col-xl-4.col-xxl-3.o-productList__itemWrapper");
        selectedItemInfo = selectedItem.getText();
        selectedItem.click();
    }

    public void writeProductInfoInTXT() {
        try {
            Utility.txtWrite(selectedItemInfo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
