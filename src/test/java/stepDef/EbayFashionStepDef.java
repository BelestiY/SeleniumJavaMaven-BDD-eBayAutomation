package stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageObj.AbstractPage;
import pageObj.EbayFashionPage;

public class EbayFashionStepDef extends AbstractPage {
    private WebDriver driver;
    private EbayFashionPage ebayFashionPage;

    public EbayFashionStepDef() {
        this.driver = super.driver;
    }

    @And("user hover over on the Fashion menu")
    public void userHoverOverOnTheFashionMenu() {
        ebayFashionPage = ebayLoginPage.hoverOverFashionMenu();
    }

    @And("user selects {string} category of fashion")
    public void userSelectsCategoryOfFashion(String category) {
        ebayFashionPage.selectCategory(category);
    }

    @Then("user would land on the {string} page of fashion menu")
    public void userWouldLandOnThePageOfFashionMenu(String actualCategory) {
        String expectedCategory = ebayFashionPage.getCategoryHeader();
        Assert.assertEquals(actualCategory, expectedCategory);
    }

    @And("user selects the {string} result of the selected category")
    public void userSelectsTheResultOfTheSelectedCategory(String index) {
        ebayFashionPage.selectFashionCategoryByIndex(index);
    }

    @And("user selects the {string} result of the selected fashion item")
    public void userSelectsTheResultOfTheSelectedFashionItem(String index) {
        ebayFashionPage.selectFashionByIndex(index);
    }

    @And("user sets {string} width for the selected fashion item")
    public void userSetsWidthForTheSelectedFashionItem(String width) {
        ebayFashionPage.setWidth(width);
    }

    @And("user sets {string} size in the selected fashion item")
    public void userSetsSizeInTheSelectedFashionItem(String size) {
        ebayFashionPage.setSize(size);
    }

    @And("user sets {string} for the selected fashion item")
    public void userSetsForTheSelectedFashionItem(String quantity) {
        ebayFashionPage.setQuantity(quantity);
    }

    @And("user clicks on the Add to cart button to add the selected fashion category")
    public void userClicksOnTheAddToCartButtonToAddTheSelectedFashionCategory() {
        ebayFashionPage.clickOnAddToCartButton();
    }

    @Then("user would get {string} added fashion items in the cart")
    public void userWouldGetAddedFashionItemsInTheCart(String actualNumItems) {
        String expectedNumItems = ebayFashionPage.getNumAddedItemsToCart();
        Assert.assertEquals(actualNumItems, expectedNumItems);
    }
}
