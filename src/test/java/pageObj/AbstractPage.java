package pageObj;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AbstractPage {
    public static String parentWindow;
    public static WebDriver driver;
    public static boolean folderCreated=false;
    public static boolean userLoginStatus=false;
    public static EbayLoginPage ebayLoginPage;
    public static EbaySearchPage ebaySearchPage;
    public static EbayElectronicsPage ebayElectronicsPage;
    public static EbayFashionPage ebayFashionPage;

    @FindBy(id = "qtyTextBox")
    private WebElement qtyTextBox;
    @FindBy(xpath = "//a/span/span[.='Add to cart']")
    private WebElement addToCartButton;
    @FindBy(id = "gh-cart-n")
    private WebElement numAddedItemsToCart;

    public String getNumAddedItemsToCart() {
        return this.numAddedItemsToCart.getText();
    }
    public void clickOnAddToCartButton() {
        this.addToCartButton.click();
        smartWait(2);
    }
    public void setQuantity(String quantity) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true)", qtyTextBox);
        this.qtyTextBox.clear();
        int qnty = Integer.parseInt(quantity);
        this.qtyTextBox.sendKeys(Integer.toString(qnty));
        smartWait(2);
    }
    public void smartWait(int sec) {
        try {
            Thread.sleep(sec * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void setDriver(WebDriver driverObj){
        driver=driverObj;
    }
    public static void setParentWindow(String windowID){
        parentWindow=windowID;
    }
    public static String getParentWindow(){
        return parentWindow;
    }
}