package stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import runnerTest.webPages.LoginPage;
import utils.Constants;

public class LoginPageSD {

    private LoginPage loginPage = new LoginPage();

    @Given("^I am on the darksky login page$")
    public void getPageTitle() {
        String title = loginPage.getHomePageTitle();
        Assert.assertEquals(title, Constants.LOGIN_PAGE_TITLE);
    }

    @When("^I enter (.+) into (email|password) text fields on login page$")
    public void enterDataUserAndPasswordFiled(String anyText, String textField){
        switch (textField){
            case "email":
                loginPage.enterEmail(anyText);
                break;
            case "password":
                loginPage.enterPassword(anyText);
                break;
        }
    }


    @And("^I click on login button$")
    public void clickOnLogin(){
        loginPage.clickOnLogin();
    }

    @Then("^I verify error message “password and username does not match”$")
    public void getErrorText(){
        String errorMessage = loginPage.getErrorMessage();
        System.out.println(errorMessage);
        Assert.assertEquals(errorMessage, Constants.ERROR_MESSAGE);
    }
}
