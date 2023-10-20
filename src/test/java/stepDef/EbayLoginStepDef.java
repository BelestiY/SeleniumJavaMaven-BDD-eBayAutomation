package stepDef;

import config.Config;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageObj.AbstractPage;
import pageObj.EbayLoginPage;

public class EbayLoginStepDef extends AbstractPage {
    private WebDriver driver;
    private EbayLoginPage ebayLoginPage;

    public EbayLoginStepDef() {
        this.driver = super.driver;
    }

    @When("user has entered ebay system URL")
    public void userHasEnteredEbaySystemURL() {
        driver.get(Config.ebayURL);
        ebayLoginPage = new EbayLoginPage(driver);
        super.ebayLoginPage = ebayLoginPage;
    }

    @And("user clicks on the sign in link")
    public void userClicksOnTheSignInLink() {
        ebayLoginPage.clickOnSignInLink();
    }

    @And("user clicks on the register link")
    public void userClicksOnTheRegisterLink() {
        ebayLoginPage.clickOnRegisterLink();
    }

    @Then("user would land on create account page")
    public void userWouldLandOnCreateAccountPage() {
        Assert.assertTrue(ebayLoginPage.isAccountPageReturned());
    }

    @And("user enters {string} into first name text field")
    public void userEntersIntoFirstNameTextField(String firstName) {
        ebayLoginPage.setFirstName(firstName);
    }

    @And("user enters {string} into last name text field")
    public void userEntersIntoLastNameTextField(String lastName) {
        ebayLoginPage.setLastName(lastName);
    }

    @And("user clicks on the Create Account button")
    public void userClicksOnTheCreateAccountButton() {
        ebayLoginPage.clickOnCreateAccountButton();
    }

    @And("user enters {string} into the email text field")
    public void userEntersIntoTheEmailTextField(String email) {
        ebayLoginPage.setEmail(email);
    }

    @And("user enters {string} into the password text field")
    public void userEntersIntoThePasswordTextField(String password) {
        ebayLoginPage.setPassword(password);
    }

    @Then("user would land on the sign in page")
    public void userWouldLandOnTheSignInPage() {
        Assert.assertTrue(ebayLoginPage.isSignInPageReturned());
    }

    @And("user enters {string} into user id text field")
    public void userEntersIntoUserIdTextField(String emailOrUsername) {
        ebayLoginPage.setEmailOrUsername(emailOrUsername);
    }

    @And("user clicks on the Sign-in Continue button")
    public void userClicksOnTheSignInContinueButton() {
        ebayLoginPage.clickOnSignInContinueButton();
    }

    @And("user enters {string} into the pass text field")
    public void userEntersIntoThePassTextField(String pass) {
        ebayLoginPage.setPass(pass);
    }

    @And("user clicks on the Sign in button")
    public void userClicksOnTheSignInButton() {
        ebayLoginPage.clickOnSignInButton();
    }

    @Then("user would get {string} in the profile menu")
    public void userWouldGetInTheProfileMenu(String actualProfileName) {
        String expectedProfileName = ebayLoginPage.getProfileName();
        Assert.assertEquals(actualProfileName, expectedProfileName);
    }
}
