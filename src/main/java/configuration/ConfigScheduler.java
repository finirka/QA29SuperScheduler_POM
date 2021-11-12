package configuration;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.events.EventFiringWebDriverFactory;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/*

"platformName": "Android",
  "deviceName": "Nexus",
  "platformVersion": "8.0",
  "appPackage": "com.example.svetlana.scheduler",
  "appActivity": ".presentation.splashScreen.SplashScreenActivity"

 */
public class ConfigScheduler {
    protected AppiumDriver<MobileElement> driver;

    Logger logger = LoggerFactory.getLogger(ConfigScheduler.class);

@BeforeSuite
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName","Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"8.0");
        capabilities.setCapability("deviceName","Nexus");
        capabilities.setCapability("appPackage","com.example.svetlana.scheduler");
        capabilities.setCapability("appActivity",".presentation.splashScreen.SplashScreenActivity");

        capabilities.setCapability("automationName","Appium");

        driver = new AppiumDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        //driver= EventFiringWebDriverFactory.getEventFiringWebDriver(driver, new AppiumListener());
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        logger.info("Start super scheduler");
    }

@AfterSuite
    public void tearDown(){
    driver.quit();
    }

    @AfterMethod
    public void stopLogger (Method m){
        logger.info("Stop method -->" +m.getName());
    }

    @BeforeMethod
    public void startLogger (Method m){
        logger.info("Start method -->" +m.getName());
    }

}
