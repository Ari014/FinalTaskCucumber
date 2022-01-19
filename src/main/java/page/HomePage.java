package page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{


    @FindBy(xpath = "//*[@id=\"chrome-search\"]")
    private WebElement searchInput;

    @FindBy(xpath = "//*[@data-testid=\"search-button-inline\"]")
    private WebElement searchButton;

    @FindBy(xpath = "//*[@data-testid=\"savedItemsIcon\"]")
    private WebElement WishListButton;

    @FindBy(xpath = "//*[@icon=\"_3iH_8F6\"]")
    private WebElement myAccountButton;

    @FindBy(xpath = "//*[@data-navid=\"6f523749-e60d-4c56-bcbc-8c3ab412511c\"]")
    private WebElement homeButton;

    @FindBy(xpath = "//*[@data-navid=\"1020946c-8949-4e9c-9719-43435002bcd4\"]")
    private WebElement newInButton;

    @FindBy(xpath = "//*[@data-navid=\"96b432e3-d374-4293-8145-b00772447cde\"]")
    private WebElement clothingButton;

    @FindBy(xpath = "//*[@data-navid=\"57242f2c-d207-471c-95b1-31d6839df360\"]")
    private WebElement finalSaleButton;


    @FindBy(xpath = "//*[@icon=\"AckDUvD\"]")
    private WebElement myBagButton;









    public HomePage(WebDriver driver) {
        super(driver);
    }


    public void openHomePage(String url) {
        driver.get(url);
    }

    public void searchByKeyword (final String keyword) {
        searchInput.sendKeys(keyword);
    }

    public void clickOnSearchButton() {
        searchButton.click();
    }

    public void clickOnWishListButton() {
        WishListButton.click();
    }

    public void clickOnMyBagButton() {
        myBagButton.click();
    }


}
