package stepDefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import runnerTest.webPages.ElementUtil;
import utils.BasePage;
import utils.ConfigReader;

import java.io.File;
import java.io.IOException;

public class SharedSD {

    // Hook Class

    ElementUtil elementUtil = new ElementUtil();
    private static Logger logger = Logger.getLogger(SharedSD.class);

    @Before
    public void setUp(){
        logger.info("***************************************");
        logger.info("Test setup method is starting...!");
        ConfigReader.getProperty("browser");
        BasePage.get().get(ConfigReader.getProperty("url"));
        BasePage.get().manage().window().maximize();
    }

    @After
    public void tearDown(Scenario scenario){
        if(scenario.isFailed()){
            logger.error("Test Failed...!");
            File scrFile = ((TakesScreenshot)BasePage.get()).getScreenshotAs(OutputType.FILE);
            try {
                FileUtils.copyFile(scrFile, new File(elementUtil.getScreenShot("pic")));
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }else{
            logger.info("Cleanup..!");
            logger.info("Test was completed...!");
        }
        logger.info("************************");
        BasePage.closeBrowser();
    }
}
