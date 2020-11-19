package runnerTest.webPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BasePage;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

public class TimeLine extends ElementUtil{

    // Locators
    private By hours = By.xpath("//div[@class='scroll-container']//span[@class='hour']");
    private By locationBox = By.xpath("//body/div[@id='header']/form[@id='searchForm']/input[1]");
    private By searchBtn = By.xpath("//body/div[@id='header']/form[@id='searchForm']/a[2]");

    // Methods
    public String getPageTitle(){
        return BasePage.get().getTitle();
    }

    public void timeLine(){
        List<WebElement> timeLineList = BasePage.get().findElements(hours);
        for(int i = 0; i < timeLineList.size(); i++){
            String list = timeLineList.get(i).getText();
            if(!list.isEmpty()){
                System.out.print(list + " ");
            }
        }
    }

    public void enterCity(String city){
        clear(locationBox);
        sendValue(locationBox, city);
        clickOn(searchBtn);
    }

    public void verifyTimeZone(String city) throws InterruptedException {
        clear(locationBox);
        sendValue(locationBox,city);
        clickOn(searchBtn);
        Thread.sleep(3000);
        String timeZone = BasePage.get().getPageSource();
        int index = timeZone.indexOf("tz_offset = ");
        System.out.println(timeZone.substring(index + 12, index + 13));
        Date date = new Date();
        DateFormat gmtFormat = new SimpleDateFormat();
        TimeZone timeZone2 = TimeZone.getTimeZone("GMT" + "+" + timeZone.substring(index + 12, index + 13));
        gmtFormat.setTimeZone(timeZone2);
        System.out.println("Current Time at my location : " + date);
        System.out.println("Current Time at " + city + " : " +gmtFormat.format(date));
    }

    public boolean checkTimeLine(){
        List<WebElement> displayedHours = webElements(hours);
        System.out.println(displayedHours);
        ArrayList<Integer> hours = new ArrayList<>();
        for (int i = 0; i < displayedHours.size(); i++){
            String regexHours = displayedHours.get(i).getText();
            regexHours = regexHours.replaceAll("[^0-9]","");
            int intHours = Integer.parseInt(regexHours);
            hours.add(intHours);
        }
        for(int j=0;j<hours.size();j++){
            for(int k=j+1;k<hours.size();k++){
                int hoursDifference=hours.get(k)-hours.get(j);
                if(!(hoursDifference==2)){
                    return false;
                }
            }
        }
        return true;
    }
}
