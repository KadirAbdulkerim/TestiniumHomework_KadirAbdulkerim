package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * @author Kadirdan Abdukerim
 * @create 2022-10-06-5:01 PM
 */
public class CartPage {
    private WebDriver driver;

    private By successMessage = By.cssSelector("div[id='emtyCart'] strong[class='m-empty__messageTitle']");


    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getPriceFromCart() {
        return driver.findElement(By.xpath("//span[normalize-space()='" + ProductDetailPage.itemName + "']/../../following::div[1]//span[@class='m-productPrice__salePrice']")).getText();
    }

    public void clickOnItemName() {
        driver.findElement(By.xpath("//span[normalize-space()='" + ProductDetailPage.itemName + "']")).click();
    }

    public String getItemCount() {
        return driver.findElement(By.xpath("//span[normalize-space()='" + ProductDetailPage.itemName + "']/../../following::div[1]//select/option[2]")).getAttribute("value");
    }

    public void clickOnSilButton() {
        driver.findElement(By.xpath("//span[normalize-space()='" + ProductDetailPage.itemName + "']/../../button")).click();
    }

    public String getMessage() {
        return driver.findElement(successMessage).getText();
    }
}
