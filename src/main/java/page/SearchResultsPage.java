package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchResultsPage extends BasePage{


    @FindBy(xpath = "//*[@src=\"//images.asos-media.com/products/champion-training-t-shirt-top-in-white/24438435-1-white?$n_480w$&wid=476&fit=constrain\"]")
    private WebElement IconOfProducts;

    @FindBy(xpath = "//*[@id=\"product-23256193\"]/a")
    private WebElement AddProductInWishList;



    @FindBy(xpath = "//*[@class=\"_1om7l06\"]")
    private List<WebElement> AmountFilterOfProducts;



    @FindBy(xpath = "//*[@class=\"a-size-base-plus a-color-base a-text-normal\"]")
    private List<WebElement> searchResultsProductsList;

    @FindBy(xpath = "//button[@data-auto-id='saveForLater']")
    private WebElement wishListFirstElementButton;

    @FindBy(xpath = "//section[@class='grid-text__container']")
    private WebElement header;

    @FindBy(xpath = "//span[@class='error basic-error-box']")
    private WebElement errorMessage;

    @FindBy(xpath = "//article[@data-auto-id='productTile']")
    private WebElement product;

    @FindBy(xpath = "//button[@data-test-id='add-button']")
    private WebElement addToBagButton;


    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }


    public List<WebElement> getSearchResultsList() {
        return searchResultsProductsList;
    }



    public void ClickOnAddProductInWishList() {
       AddProductInWishList.click();
    }



    public List<WebElement> getSearchResultsFilters() {
        return AmountFilterOfProducts;
    }

    public void clickWishListFirstElementButton() {
        wishListFirstElementButton.click();
    }

    public String getTextHeader() {
        return header.getText();
    }

    public String checkErrorMessageAddingCart() {
        return errorMessage.getText();
    }
    public void clickOnProduct(){
        product.click();
    }

    public void clickAddToBagButton() {
        addToBagButton.click();
    }
}
