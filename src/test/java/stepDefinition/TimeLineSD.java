package stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import runnerTest.webPages.TimeLine;
import utils.Constants;

public class TimeLineSD {

    private TimeLine timeLine = new TimeLine();

    @Given("^Verify timeline is displayed in correct format$")
    public void verifyTimeline(){
        timeLine.timeLine();
    }

    @When("^I enter city into search text field on home screen$")
    public void verifyCityName() throws InterruptedException {
        timeLine.enterCity(Constants.LOCATION);
        Thread.sleep(4000);
        Assert.assertEquals(timeLine.getPageTitle(),"Dark Sky - 179 Washington Ave, Secaucus, NJ");
    }

    @And("^I verify city’s time zone$")
    public void cityTimeZone() throws InterruptedException {
        timeLine.verifyTimeZone("Manila");
    }

    @Then("^I verify timeline is displayed with two hours incremented$")
    public void verifyIncrement(){
        timeLine.checkTimeLine();
    }

}
