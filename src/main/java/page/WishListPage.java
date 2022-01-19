package page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WishListPage extends BasePage{


    @FindBy(xpath = "//*[@class=\"itemCount_3vWat\"]")
    private WebElement AmountProductsInWishList;


    @FindBy(xpath = "//*[@value=\"24438762\"]")
    private WebElement selectSizeSMComboBox;

    @FindBy(xpath = "//*[@class=\"toBagButton_1OxXm toBagButton_20T0u\"]")
    private WebElement moveToBagButton;

    @FindBy(xpath = "//select[@aria-label=\"Size\"]")
    private WebElement sizeField;




    @FindBy(xpath = "//a[@data-test-id='bag-link']")
    private WebElement viewBagButton;



    public WishListPage(WebDriver driver) {
        super(driver);
    }

    public String getAmountProductsInWishList() {
        return AmountProductsInWishList.getText();
    }

    public void clickOnSelectSizeField() {
        sizeField.click();
    }
    public void clickOnSizeSMComboBox() {
        selectSizeSMComboBox.click();
    }

    public void clickOnMoveToBagButton() {
        moveToBagButton.click();
    }
    public void clickOnFirstSize() {
        sizeField.sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN);
        sizeField.click();
    }

    public void clickAddToCartButton() {
        moveToBagButton.click();
    }

    public void clickViewBagButton() {
        viewBagButton.click();
    }
}
