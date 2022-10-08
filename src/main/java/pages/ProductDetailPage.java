package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageutility.Utility;

/**
 * @author Kadirdan Abdukerim
 * @create 2022-10-06-5:00 PM
 */
public class ProductDetailPage {

    private WebDriver driver;
    public static String itemName;
    String price;

    public By selectedItem = By.cssSelector(".o-productDetail__brandLink");
    public By itemSize = By.cssSelector(".m-variation span");
    private By newPrice = By.cssSelector("#priceNew");
    private By sepeteEkleButton = By.cssSelector("#addBasket");
    private By sepetimLink = By.cssSelector("a[title='Sepetim'] span[class='o-header__userInfo--text']");
    private By itemNameLocator = By.cssSelector(".o-productDetail__description");

    public ProductDetailPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void getPriceValue() {
        String price = driver.findElement(newPrice).getText();
        setPrice(price);
    }

    public String getSelectedItem() {
        return driver.findElement(selectedItem).getText();
    }

    public void selectEnableSize() {
        Utility.randomSelectItemSize(itemSize).click();
    }

    public void clickOnSepeteEkle() {
        driver.findElement(sepeteEkleButton).click();
    }

    public void clickOnButton(String button){
        switch (button){
            case "SEPETE EKLE":
                clickOnSepeteEkle();
                break;
        }
    }

    public void clickOnSepetimLink() {
        driver.findElement(sepetimLink).click();
    }

    public void clickOnLink(String link){
        switch (link){
            case "Sepetim":
                clickOnSepetimLink();
                break;
        }

    }

    public void getItemNameFromLocator() {
        itemName = driver.findElement(itemNameLocator).getText();
    }

    public void clickOnNewSize() {
        Utility.randomSelectItemSize(Utility.indexNum, itemSize).click();
    }
}
