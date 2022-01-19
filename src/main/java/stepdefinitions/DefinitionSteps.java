package stepdefinitions;

import io.cucumber.java.After;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import manager.PageFactoryManager;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import page.*;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;
import static java.lang.Thread.sleep;
import static org.junit.Assert.assertTrue;

public class DefinitionSteps {
    private static final long   DEFAULT_TIMEOUT = 60;
    WebDriver driver;
    HomePage homePage;
    WishListPage wishListPage;
    SearchResultsPage searchResultsPage;
    SignInPage signInPage;
    BagPage bagPage;
    PageFactoryManager pageFactoryManager;

    @Before
    public void TestSetUp() {
        chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        pageFactoryManager = new PageFactoryManager(driver);
    }

    @After
    public void tearDown() {driver.close();}


    @And("User opens {string} page")
    public void openPage(final String url) {
        homePage = pageFactoryManager.getHomePage();
        homePage.openHomePage(url);
    }


    @And("User makes search by keyword {string}")
    public void MakeSearchByKeywordKeyword(final String keyword) {
        homePage.searchByKeyword(keyword);
    }

    @And("User clicks search button")
    public void ClicksSearchButton()  {
        homePage.clickOnSearchButton();
    }

    @And("User checks that current url contains {string} ")
    public void checkCurrentUrl(final String keyword) {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        assertTrue(driver.getCurrentUrl().contains(keyword));
    }



    @Then("User checks that current url contains {string}")
    public void CheckThatCurrentUrlContainKeyword(final String keyword) {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        assertTrue(driver.getCurrentUrl().contains(keyword));
    }


    @Then("User checks that amount of products in wish list are {string}")
    public void CheckThatAmountOfProductsInWishListAreAmountOfProducts(final String amount) {
        wishListPage = pageFactoryManager.getWishListPage();
        wishListPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        wishListPage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        wishListPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        wishListPage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        assertTrue(wishListPage.getAmountProductsInWishList().contains(amount));

    }

    @And("User clicks add  first product in wish list")
    public void ClickAddFirstProductInWishList() {
        searchResultsPage.ClickOnAddProductInWishList();
    }


    @And("User clicks wish list button")
    public void ClickWishListButton() {
        searchResultsPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        searchResultsPage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        homePage.clickOnWishListButton();
        wishListPage = pageFactoryManager.getWishListPage();
        wishListPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        wishListPage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
    }

    @Then("User checks that amount of filters on search page are {string}")
    public void CheckThatAmountOfFiltersOnSearchPageAreAmountOfProducts(final String expectedAmount) {
        searchResultsPage = pageFactoryManager.getSearchResultsPage();
        searchResultsPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        searchResultsPage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
         int amount = 0;
        for (WebElement webElement : searchResultsPage.getSearchResultsFilters()) {
            amount++;
        }
        assertEquals(amount, Integer.parseInt(expectedAmount));

    }



    @And("User clicks SignIn form")
    public void ClickSignInForm() {
        bagPage = pageFactoryManager.getBagPage();
        bagPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        bagPage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        bagPage.clickOnSignForm();


    }

    @And("User checks that Join button visible")
    public void CheckThatJoinButtonVisible() {
        signInPage = pageFactoryManager.getSignInPage();
        signInPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        signInPage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        assertTrue(signInPage.isJoinButtonVisible());
    }

    @And("User checks that SignIn button visible")
    public void CheckThatSignInButtonVisible() {
        assertTrue(signInPage.isSignInButtonVisible());
    }

    @And("User checks Email Address input visibility")
    public void CheckEmailAddressInputVisibility() {
        assertTrue(signInPage.isEmailAddressInputVisible());
    }

    @And("User checks Password input visibility")
    public void CheckPasswordInputVisibility() {
        assertTrue(signInPage.isPasswordInputVisible());

    }

    @And("User checks Forgot Password button visibility")
    public void CheckForgotPasswordButtonVisibility() {

        assertTrue(signInPage.isForgotPasswordInputVisible());
    }


    @When("User enters email {string}")
    public void EnterEmailKeyword(final String email) {
       signInPage = pageFactoryManager.getSignInPage();
        signInPage.enterTextToEmailAddressField(email);

    }

    @And("User clicks SignIn button")
    public void ClickSignInButton() {
        signInPage = pageFactoryManager.getSignInPage();
        signInPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        signInPage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        signInPage.ClickOnSignInButton();
    }

    @Then("User checks that warning is {string}")
    public void CheckThatWarningIsWarning(final String  warning) {
        assertEquals(signInPage.getPasswordErrorText(), warning );
    }

    @And("User enters password {string}")
    public void EnterPasswordKeyword(final String password) {
        signInPage.enterTextToPasswordField(password);
    }

    @Then("User checks that error about  account is {string}")
    public void CheckThatErrorAboutAccountIsError(final String error) {
        signInPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        signInPage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        assertEquals(signInPage.getAccountErrorText(), error );
    }

    @Then("User checks that warning about  email is {string}")
    public void CheckThatWarningAboutEmailIsWarning(final String warning) {
        signInPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        signInPage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        assertEquals(signInPage.getEmailAddressErrorText(), warning );
    }

    @And("User clicks wish list on first product")
    public void clickWishListOnFirstProduct() {
        searchResultsPage = pageFactoryManager.getSearchResultsPage();
        searchResultsPage.clickWishListFirstElementButton();
    }




    @Then("User checks that cart page header is {string}")
    public void CheckThatCartPageHeaderIsHeader(final String Header) {

        bagPage = pageFactoryManager.getBagPage();
        bagPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        bagPage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        assertTrue(bagPage.checkCartPage().contains(Header));
    }

    @And("User clicks myBag button")
    public void ClickMyBagButton() {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        homePage.clickOnMyBagButton();
        bagPage = pageFactoryManager.getBagPage();
        bagPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        bagPage.waitForAjaxToComplete(DEFAULT_TIMEOUT);

    }



    @Then("User checks lack of products with {string}")
    public void checkLackOfProductsWithSearchHeader(final String searchHeader) {
        searchResultsPage = pageFactoryManager.getSearchResultsPage();
        assertTrue(searchResultsPage.getTextHeader().contains(searchHeader));
    }

    @Then("User checks that amount of products in bag are {string}")
    public void CheckThatAmountOfProductsInBagAreAmountOfProducts(final String amount) {
        bagPage = pageFactoryManager.getBagPage();
        bagPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        bagPage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        bagPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        bagPage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        assertEquals(amount, bagPage.getAmountOfProductsInBag());
    }


    @And("User clicks on first product")
    public void clickOnFirstProduct() {
        searchResultsPage = pageFactoryManager.getSearchResultsPage();
        searchResultsPage.clickOnProduct();
    }


    @And("User clicks Add to Bag button on product")
    public void clickToBagButton() {
        searchResultsPage.clickAddToBagButton();
        searchResultsPage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        searchResultsPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        searchResultsPage.waitForAjaxToCompletePdp(DEFAULT_TIMEOUT);

    }


    @Then("User checks the {string}")
    public void checkTheMessage(final String errorMessage) {
        assertTrue(searchResultsPage.checkErrorMessageAddingCart().contains(errorMessage));
    }
}
