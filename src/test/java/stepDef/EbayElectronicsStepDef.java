package stepDef;

//import io.cucumber.java.en.And;
//import io.cucumber.java.en.Then;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageObj.AbstractPage;
import pageObj.EbayElectronicsPage;

public class EbayElectronicsStepDef extends AbstractPage {
    private WebDriver driver;
    private EbayElectronicsPage ebayElectronicsPage;

    public EbayElectronicsStepDef() {
        this.driver = super.driver;
    }

    @And("user clicks on the Electronics menu")
    public void userClicksOnTheElectronicsMenu() {
        ebayElectronicsPage = ebayLoginPage.clickOnElectronicsMenu();
    }

    @Then("user would land on the Electronics page")
    public void userWouldLandOnTheElectronicsPage() {
        Assert.assertTrue(ebayElectronicsPage.isElectronicsLabelReturned());
    }

    @And("user selects {string} of electronics")
    public void userSelectsOfElectronics(String category) {
        ebayElectronicsPage.selectCategory(category);
    }

    @Then("user would land on the {string} page")
    public void userWouldLandOnThePage(String actualCategory) {
        String expectedCategory = ebayElectronicsPage.getCategory();
        Assert.assertEquals(actualCategory, expectedCategory);
    }

    @And("user clicks on the {string} gaming station category")
    public void userClicksOnTheGamingStationCategory(String index) {
        ebayElectronicsPage.selectGamingStation(index);
    }

    @And("user clicks on the {string} play station category")
    public void userClicksOnThePlayStationCategory(String index) {
        ebayElectronicsPage.selectPlayStation(index);
    }

    @And("user selects the {string} play station")
    public void userSelectsThePlayStation(String index) {
        ebayElectronicsPage.clickOnTheSelectedPlayStation(index);
    }

    @And("user sets {string} in the quantity label for the play station")
    public void userSetsInTheQuantityLabelForThePlayStation(String quantity) {
        ebayElectronicsPage.setQuantity(quantity);
    }

    @And("user clicks on the Add to cart button to add the selected play station")
    public void userClicksOnTheAddToCartButtonToAddTheSelectedPlayStation() {
        ebayElectronicsPage.clickOnAddToCartButton();
    }

    @Then("user would get {string} play station items in the cart")
    public void userWouldGetPlayStationItemsInTheCart(String actualNumPlayStations) {
        String expectedNumPlayStations = ebayElectronicsPage.getNumAddedItemsToCart();
        Assert.assertEquals(actualNumPlayStations, expectedNumPlayStations);
    }

}
