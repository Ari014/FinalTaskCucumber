package manager;

import org.openqa.selenium.WebDriver;
import page.*;

public class PageFactoryManager {

    WebDriver driver;



    public PageFactoryManager(WebDriver driver) {
        this.driver = driver;

    }

    public HomePage getHomePage() {
        return new HomePage(driver);}

    public BagPage getBagPage() {
        return new BagPage(driver);}



    public SearchResultsPage getSearchResultsPage() {
        return new SearchResultsPage(driver);}

    public SignInPage getSignInPage() {
        return new SignInPage(driver);
    }
    public WishListPage getWishListPage() {
        return new WishListPage(driver);
    }

}
