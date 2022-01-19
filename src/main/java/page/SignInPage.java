package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignInPage extends BasePage{

    @FindBy(xpath = "//*[@class=\"title qa-title with-link\"]")
    private WebElement joinButton;

    @FindBy(xpath = "//*[@data-st-field=\"id-signIn-emailAddress\"]")
    private WebElement emailAddressInput;

    @FindBy(xpath = "//*[@data-st-field=\"id-signIn-password\"]")
    private WebElement passwordInput;

    @FindBy(xpath = "//*[@id=\"signin\"]")
    private WebElement signInButton;

    @FindBy(xpath = "//*[@class=\"title qa-title with-link\"]")
    private WebElement forgotPasswordButton;

    @FindBy(xpath = "//*[@id=\"Password-error\"]")
    private WebElement passwordError;

    @FindBy(xpath = "//*[@id=\"loginErrorMessage\"]")
    private WebElement accountError;


    @FindBy(xpath = "//*[@id=\"EmailAddress-error\"]")
    private WebElement emailAddressError;




    public void enterTextToEmailAddressField(final String email) {
        emailAddressInput.sendKeys(email);
    }

    public void enterTextToPasswordField(final String password) {
        passwordInput.sendKeys(password);
    }

    public SignInPage(WebDriver driver) {
        super(driver);

    }

    public boolean isJoinButtonVisible() {
        return joinButton.isDisplayed();
    }

    public boolean isEmailAddressInputVisible() {
        return emailAddressInput.isDisplayed();
    }

    public boolean isPasswordInputVisible() {
        return passwordInput.isDisplayed();
    }

    public boolean isForgotPasswordInputVisible() {
        return forgotPasswordButton.isDisplayed();
    }

    public boolean isSignInButtonVisible() {
        return signInButton.isDisplayed();
    }

    public void ClickOnSignInButton() {
        signInButton.click();
    }

    public String getPasswordErrorText() {
        return passwordError.getText();
    }

    public String getAccountErrorText() {
        return accountError.getText();
    }

    public String getEmailAddressErrorText() {
        return emailAddressError.getText();
    }


}
