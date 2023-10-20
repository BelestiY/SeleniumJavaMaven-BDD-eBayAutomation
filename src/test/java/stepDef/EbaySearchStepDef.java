package stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageObj.AbstractPage;
import pageObj.EbaySearchPage;

public class EbaySearchStepDef extends AbstractPage {
    private WebDriver driver;
    private EbaySearchPage ebaySearchPage;

    public EbaySearchStepDef() {
        this.driver = super.driver;
    }



    @And("user enters {string} into Search for anything label")
    public void userEntersIntoSearchForAnythingLabel(String searchKey) {
        ebaySearchPage = ebayLoginPage.setSearchKey(searchKey);
    }

    @And("user selects {string} in the category dropdown")
    public void userSelectsInTheCategoryDropdown(String category) {
        ebaySearchPage.setCategory(category);
    }

    @And("user clicks on the Search button")
    public void userClicksOnTheSearchButton() {
        ebaySearchPage.clickOnSearchButton();
    }

    @And("user selects the {string} search result")
    public void userSelectsTheSearchResult(String index) {
        int ind = Integer.parseInt(index);
        ebaySearchPage.selectSearchResult(ind);
    }

    @And("user selects the {string} color")
    public void userSelectsTheColor(String index) {
        int ind = Integer.parseInt(index);
        ebaySearchPage.setColor(ind);
    }

    @And("user clicks on the Add to cart button")
    public void userClicksOnTheAddToCartButton() {
        ebaySearchPage.clickOnAddToCartButton();
    }

    @And("user sets {string} in the quantity label")
    public void userSetsInTheQuantityLabel(String quantity) {
        ebaySearchPage.setQuantity(quantity);
    }

    @Then("user would get {string} items in the cart")
    public void userWouldGetItemsInTheCart(String actualNumItemsAddedToCart) {
        String expectedNumItemsAddedToCart = ebaySearchPage.getNumAddedItemsToCart();
        Assert.assertEquals(actualNumItemsAddedToCart, expectedNumItemsAddedToCart);
    }
}
