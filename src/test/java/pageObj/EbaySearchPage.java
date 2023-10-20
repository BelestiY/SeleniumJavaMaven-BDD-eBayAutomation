package pageObj;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;

public class EbaySearchPage extends AbstractPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private Actions actions;

    // objects used to search items
    @FindBy(id = "gh-cat")
    private WebElement categoryDropdown;
    @FindBy(xpath = "//input[@value='Search']")
    private WebElement searchButton;
    @FindBy(xpath = "//button/span/span[.='Condition']")
    private WebElement conditionDropdown;
    String searchResult = "//ul/li[";
    @FindBy(id = "x-msku__select-box-1000")
    private WebElement colorDropdown;

    public EbaySearchPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
        this.actions = new Actions(driver);
    }

    public void setColor(int index) {
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));

        this.colorDropdown.click();
        Select select = new Select(colorDropdown);
        select.selectByIndex(index);
    }
    public void selectSearchResult(int index) {
        driver.findElement(By.xpath(searchResult + "" + index + "]//div[@class='s-item__title']")).click();

        smartWait(5);
    }
    public void clickOnSearchButton() {
        this.searchButton.click();
        smartWait(10);
    }
    public void setCategory(String category) {
        this.categoryDropdown.click();
        Select select = new Select(categoryDropdown);
        select.selectByVisibleText(category);
        smartWait(1);
    }
}
