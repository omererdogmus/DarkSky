package runnerTest.webPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BasePage;

public class LoginPage extends ElementUtil{

    // Locators
    private By darkSkyApi = By.xpath("//a[contains(text(),'Dark Sky API')]");
    private By loginLink = By.xpath("//a[contains(text(),'Log In')]");
    private By email = By.id("email");
    private By password = By.id("password");
    private By loginBtn = By.xpath("//button[contains(text(),'Log in')]");
    private By errorMsg = By.xpath("//div[contains(text(),'Username and password do not match')]");

    // Methods

    public void clickOnDarkSkyApi(){
        clickOn(darkSkyApi);
    }

    public void clickOnLoginLink(){
        WebElement element = BasePage.get().findElement(loginLink);
        clickElementByJS(element,BasePage.get());
    }

    public String getHomePageTitle(){
        clickOnDarkSkyApi();
        clickOnLoginLink();
        String title = BasePage.get().getTitle();
        System.out.println(title);
        return title;
    }

    public void enterEmail(String enterEmail){
        sendValue(email, enterEmail);
    }

    public void enterPassword(String enterPassword){
        sendValue(password, enterPassword);
    }

    public void clickOnLogin(){
        clickOn(loginBtn);
    }

    public String getErrorMessage(){
        return getTextFromElement(errorMsg);
    }
}
