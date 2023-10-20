package pageObj;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class EbayElectronicsPage extends AbstractPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private Actions actions;

    @FindBy(xpath = "//li/span[.='Electronics']")
    private WebElement electronicsLabel;
    @FindBy(xpath = "//ul/li[3]/a/span")
    private WebElement categoryLabel;
    String gamingStation = "//div[@id='mainContent']/section[";
    String playStation = "//ul/li[@class='carousel__snap-point'][";
    String selectedPlayStation = "//ul/li[@class='s-item s-item--large'][";

    @FindBy(id = "qtyTextBox")
    private WebElement qtyTextBox;
    @FindBy(xpath = "//a/span/span[.='Add to cart']")
    private WebElement addToCartButton;
    @FindBy(id = "gh-cart-n")
    private WebElement numAddedItemsToCart;

    public EbayElectronicsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
        this.actions = new Actions(driver);
    }

    public void clickOnTheSelectedPlayStation(String index) {
        int ind = Integer.parseInt(index);
        driver.findElement(By.xpath(selectedPlayStation + ind + "]")).click();
    }
    public void selectPlayStation(String index) {
        int ind = Integer.parseInt(index);
        driver.findElement(By.xpath(playStation + ind + "]")).click();
    }
    public void selectGamingStation(String index) {
        int ind = Integer.parseInt(index);
        driver.findElement(By.xpath(gamingStation + ind + "]//a/span[.='Go for it']")).click();
    }
    public String getCategory() {
        return this.categoryLabel.getText();
    }
    public void selectCategory(String category) {
        String categoryPart = "//ul/li/a[.='";
        driver.findElement(By.xpath(categoryPart + category + "']")).click();
    }
    public boolean isElectronicsLabelReturned() {
        return this.electronicsLabel.isDisplayed();
    }


}
