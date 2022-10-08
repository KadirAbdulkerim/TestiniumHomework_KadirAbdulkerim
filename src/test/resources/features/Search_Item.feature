@Test
Feature: www.beymen.com search item functionality

  Background:
    Given user navigates to "https://www.beymen.com/"

  @RegressionTest
  Scenario: Delete the items in the Shopping cart after adding
    Given user is on the home page
    Then page title should be "Beymen.com – Türkiye’nin Tek Dijital Lüks Platformu"
    When user enters item name 1 in the search box
    # item name 1 : şort (value from Testinium.xlsx)
    * user clears the search box
    * user enters item name 2 in the search box
    # item name 2 : gömlek (value from Testinium.xlsx)
    * user press ENTER key
    Then user is navigated to the search result page
    # searched item : gömlek
    When user selects a random product from the result list
    Then user should be navigated to the selected product detail page
    * user gets the product price
    * user selects product size randomly
    * user clicks on the "SEPETE EKLE" button
    * user clicks on the "Sepetim" link
    Then user verifies product price
    When user returns to the product detail page
    * user selects same product size
    * user clicks on the "SEPETE EKLE" button
    * user clicks on the "Sepetim" link
    Then product count should be "2"
    When user clicks on the "Sil"
    Then user should be able to see success message "SEPETINIZDE ÜRÜN BULUNMAMAKTADIR"






