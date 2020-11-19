package runnerTest.webPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.BasePage;

import java.util.List;

public class HomePage extends ElementUtil{

    private By today = By.xpath("//span[contains(text(),'Today')]");
    private By temps = By.className("temp");
    private By lowest = By.className("minTemp");
    private By highest = By.className("maxTemp");

    public String getHomePageTitle(){
        String title = BasePage.get().getTitle();
        System.out.println(title);
        return title;
    }

    public void clickOnToday(){
        specificScrollPageDown();
        WebDriverWait wait = new WebDriverWait(BasePage.get(),20);
        wait.until(ExpectedConditions.elementToBeClickable(today));
        WebElement element = BasePage.get().findElement(today);
        clickElementByJS(element, BasePage.get());
    }

    public void getMinAndMaxTemp() {
        List<WebElement> list = BasePage.get().findElements(temps);
        for (int i = 0; i < list.size(); i++) {
            String temps = list.get(i).getText();
            if (!temps.isEmpty()) {
                System.out.println(temps);
            }
        }
    }

    public void verifyminAndMaxTemp(){
        String highTemp = getTextFromElement(highest);
        String lowTemp = getTextFromElement(lowest);
        System.out.println("Lowest temp is : " + lowTemp);
        System.out.println("Highest temp is : " + highTemp);
    }

}
