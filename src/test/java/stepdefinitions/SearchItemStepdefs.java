package stepdefinitions;

import factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.CartPage;
import pages.HomePage;
import pages.ProductDetailPage;
import pages.ProductsPage;
import pageutility.Utility;

/**
 * @author Kadirdan Abdukerim
 * @create 2022-10-06-7:56 PM
 */
public class SearchItemStepdefs {

    HomePage homePage = new HomePage(DriverFactory.getDriver());
    ProductsPage productsPage = new ProductsPage(DriverFactory.getDriver());
    ProductDetailPage productDetailPage = new ProductDetailPage(DriverFactory.getDriver());
    CartPage cartPage = new CartPage(DriverFactory.getDriver());
    private static String title;
    private static String firstPrice;

    @Given("user navigates to {string}")
    public void userLunchesToTheBrowser(String link) {
        System.out.println("Application name is: " + link);
        DriverFactory.getDriver().get("https://www.beymen.com/");
    }

    @Given("user is on the home page")
    public void user_on_the_home_page() {
        title = Utility.getPageTitle();
        System.out.println("Page title is: " + title);
    }

    @Then("page title should be {string}")
    public void page_title_should_be(String expectedTitleName) {
        Assert.assertEquals(title, expectedTitleName);
    }

    @When("user enters item name {int} in the search box")
    public void userEntersItemNameInTheSearchBox(int index) {
        homePage.enterItemInSearchBox(index);
    }

    @When("user clears the search box")
    public void user_clears_the_search_box() {
        homePage.clearTheFirstInput();
    }

    @When("user press ENTER key")
    public void user_press_enter_key() {
        homePage.pressEnter();
    }

    @Then("user is navigated to the search result page")
    public void user_navigates_to() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("itemName = " + homePage.searchedItemName);
        String name = productsPage.getPageName();
        Assert.assertTrue(name.contains(homePage.searchedItemName));
    }

    @When("user selects a random product from the result list")
    public void user_selects_a_product_from_product_list_randomly() {
        productsPage.selectAProductRandomly();
        productsPage.writeProductInfoInTXT();
    }

    @Then("user should be navigated to the selected product detail page")
    public void user_should_be_able_see_the_selected_product_detail_page() {
        Assert.assertTrue(ProductsPage.selectedItemInfo.contains(productDetailPage.getSelectedItem()));
    }

    @When("user gets the product price")
    public void user_gets_the_product_price() {
        productDetailPage.getPriceValue();
        firstPrice = productDetailPage.getPrice();
        System.out.println("price = " + firstPrice);
    }

    @When("user selects product size randomly")
    public void user_selects_product_size_randomly() {
        productDetailPage.selectEnableSize();
    }

    @When("user clicks on the {string} button")
    public void user_click_on_button(String button) {
        productDetailPage.clickOnButton(button);
    }

    @When("user clicks on the {string} link")
    public void user_click_on_link(String link) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        productDetailPage.getItemNameFromLocator();
        productDetailPage.clickOnLink(link);
    }

    @Then("user verifies product price")
    public void user_verifies_product_price() {
        Assert.assertEquals(firstPrice, cartPage.getPriceFromCart());
    }

    @When("user returns to the product detail page")
    public void userNavigatesToProductDetailPageAgain() {
        cartPage.clickOnItemName();
    }

    @When("user selects same product size")
    public void user_selects_product_same_size() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        productDetailPage.clickOnNewSize();
    }

    @Then("product count should be {string}")
    public void user_verifies_product_count_should_be(String productCount) {
        Assert.assertEquals(cartPage.getItemCount(), productCount);
    }

    @When("user clicks on the {string}")
    public void user_delete_the_product_by_click_on_sil_link(String link) {
        System.out.println(link);
        cartPage.clickOnSilButton();
    }

    @Then("user should be able to see success message {string}")
    public void user_should_be_able_to_see_success_message(String message) {
        Assert.assertEquals(cartPage.getMessage(), message);
    }
}
