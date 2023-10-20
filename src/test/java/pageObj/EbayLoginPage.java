package pageObj;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Base64;

public class EbayLoginPage extends AbstractPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private Actions actions;

    // objects used to create ebay account
    @FindBy(xpath = "//span[@id='gh-ug-flex']/a[.='register']")
    private WebElement registerLink;
    @FindBy(xpath = "//div/h1[.='Create an account']")
    private WebElement createAccountPage;
    @FindBy(id = "firstname")
    private WebElement firstName;
    @FindBy(id = "lastname")
    private WebElement lastName;
    @FindBy(id = "Email")
    private WebElement email;
    @FindBy(id = "password")
    private WebElement password;
    @FindBy(id = "EMAIL_REG_FORM_SUBMIT")
    private WebElement createAccountButton;

    // objects used to sign in to ebay
    @FindBy(xpath = "//span[@id='gh-ug']/a[.='Sign in']")
    private WebElement signInLink;
    @FindBy(xpath = "//span[@id='signin-reg-msg']")
    private WebElement signInPage;
    @FindBy(id = "userid")
    private WebElement emailOrUsername;
    @FindBy(id = "pass")
    private WebElement pass;
    @FindBy(id = "sgnBt")
    private WebElement signInButton;
    @FindBy(id = "signin-continue-btn")
    private WebElement signInContinueButton;
    @FindBy(xpath = "//button[@id='gh-ug']/b[1]")
    private WebElement profileName;

    // object used for searching an item
    @FindBy(xpath = "//input[@aria-label='Search for anything']")
    private WebElement searchKeyLabel;
    // object used to land on the electronics page
    @FindBy(xpath = "//li/a[.='Electronics']")
    private WebElement electronicsMenu;
    // object used to land on the fashion page
    @FindBy(xpath = "//li/a[.='Fashion']")
    private WebElement fashionMenu;


    public EbayLoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
        this.actions = new Actions(driver);
    }

    public EbayFashionPage hoverOverFashionMenu() {
        actions.moveToElement(fashionMenu).perform();

        return new EbayFashionPage(driver);
    }
    public EbayElectronicsPage clickOnElectronicsMenu() {
        this.electronicsMenu.click();
        smartWait(1);

        return new EbayElectronicsPage(driver);
    }
    public EbaySearchPage setSearchKey(String searchKey) {
        this.searchKeyLabel.clear();
        this.searchKeyLabel.sendKeys(searchKey);

        return new EbaySearchPage(driver);
    }

    // sign in to ebay
    public String getProfileName() {
        return this.profileName.getText();
    }
    public void clickOnSignInButton() {
        this.signInButton.click();
        smartWait(5);
    }
    public void setPass(String encodedPass) {
        byte[] decodedByte = Base64.getDecoder().decode(encodedPass.getBytes());
        String pass = new String(decodedByte);
        this.pass.clear();
        this.pass.sendKeys(pass);
    }
    public void clickOnSignInContinueButton() {
        this.signInContinueButton.click();
        smartWait(3);
    }
    public void setEmailOrUsername(String emailOrUsername) {
        this.emailOrUsername.clear();
        this.emailOrUsername.sendKeys(emailOrUsername);
    }
    public boolean isSignInPageReturned() {
        return this.signInPage.isDisplayed();
    }
    public void clickOnSignInLink() {
        this.signInLink.click();
        smartWait(3);
    }
    // create account
    public void clickOnCreateAccountButton() {
        this.createAccountButton.click();
        smartWait(40);
    }
    public void setPassword(String encodedPass) {
        byte[] decodedByte = Base64.getDecoder().decode(encodedPass.getBytes());
        String pass = new String(decodedByte);
        this.password.clear();
        this.password.sendKeys(pass);
    }
    public void setEmail(String email) {
        this.email.clear();
        this.email.sendKeys(email);
    }
    public void setLastName(String lastName) {
        this.lastName.clear();
        this.lastName.sendKeys(lastName);
    }
    public void setFirstName(String firstName) {
        this.firstName.clear();
        this.firstName.sendKeys(firstName);
    }
    public boolean isAccountPageReturned() {
        return this.createAccountPage.isDisplayed();
    }
    public void clickOnRegisterLink() {
        this.registerLink.click();
        smartWait(2);
    }

}
