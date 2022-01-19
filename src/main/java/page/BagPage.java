package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BagPage extends BasePage {

    @FindBy(xpath = "//*[@class=\"main-button\"]")
    private WebElement signInForm;

    @FindBy(xpath = "//div[@class='bag-contents-holder-panel bag-title-holder']")
    private WebElement cartHeader;

    @FindBy(xpath = "//*[@class=\"empty-bag-title\"]")
    private WebElement bagTitleElement;

    @FindBy(xpath = "//*[@data-bind=\"localeText: {key: 'lang_bag_empty_expired_items_generic_message'}\"]")
    private WebElement bagTextElement;


    @FindBy(xpath = "//*[@class=\"_1z5n7CN\"]")
    private WebElement amountOfProductsInBag;


    public BagPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnSignForm(){
        signInForm.click();

    }

    public String checkCartPage(){
        return cartHeader.getText();
    }



    public String getAmountOfProductsInBag() {
        return amountOfProductsInBag.getText();
    }
}
