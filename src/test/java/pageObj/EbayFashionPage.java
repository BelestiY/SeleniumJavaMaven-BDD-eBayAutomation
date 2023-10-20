package pageObj;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class EbayFashionPage extends AbstractPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private Actions actions;

    String fashionCategory = "//li/a[.='";
    @FindBy(xpath = "//h1/span[@class='b-pageheader__text']")
    private WebElement categoryHeader;
    String selectedFashionCategory = "//div[@class='b-visualnav__grid']/a[";
    String selectedFashion = "//ul[@class='carousel__list']/li[";
    @FindBy(xpath = "//span/select[@selectboxlabel='WIDTH']")
    private WebElement widthDropdown;
    @FindBy(xpath = "//span/select[@selectboxlabel='SIZE']")
    private WebElement sizeDropdown;
    @FindBy(id = "qtyTextBox")
    private WebElement qtyTextBox;
    @FindBy(xpath = "//a/span/span[.='Add to cart']")
    private WebElement addToCartButton;
    @FindBy(id = "gh-cart-n")
    private WebElement numAddedItemsToCart;



    public EbayFashionPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
        this.actions = new Actions(driver);
    }

    public void setSize(String size) {
        this.sizeDropdown.click();
        Select select = new Select(sizeDropdown);
        select.selectByValue(size);
    }
    public void setWidth(String width) {
        this.widthDropdown.click();
        Select select = new Select(widthDropdown);
        select.selectByVisibleText(width);
    }
    public void selectFashionByIndex(String index) {
        int ind = Integer.parseInt(index);
        driver.findElement(By.xpath(selectedFashion + ind + "]")).click();
    }
    public void selectFashionCategoryByIndex(String index) {
        int ind = Integer.parseInt(index);
        driver.findElement(By.xpath(selectedFashionCategory + ind + "]")).click();
    }
    public String getCategoryHeader() {
        return this.categoryHeader.getText();
    }
    public void selectCategory(String categoryName) {
        driver.findElement(By.xpath(fashionCategory +  categoryName + "']")).click();
    }
    public void smartWait(int sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
