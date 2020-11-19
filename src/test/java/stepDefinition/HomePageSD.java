package stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import runnerTest.webPages.HomePage;
import utils.Constants;

public class HomePageSD {

    private HomePage homePage = new HomePage();

    @Given("^I am on darksky home page$")
    public void pageTitle(){
       Assert.assertEquals(homePage.getHomePageTitle(), Constants.HOME_PAGE_TITLE);
    }

    @When("^I click on today button to extend it$")
    public void clickingOnToday(){
        homePage.clickOnToday();
    }

    @And("^I check lowest and highest temperature on the page$")
    public void temperatures(){
        homePage.getMinAndMaxTemp();
    }

    @Then("^I verify lowest and highest temperature on the page$")
    public void verifyTemp(){
        homePage.verifyminAndMaxTemp();
    }

}
