package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomeScreen extends BaseScreen{
    public HomeScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@resource-id='com.example.svetlana.scheduler:id/fab_main']")
    MobileElement fabAdd;
    @FindBy(xpath = "//*[@resource-id='com.example.svetlana.scheduler:id/fab_add_event']")
    MobileElement fabAddEvent;

    public boolean isFabAddButtonPresent() {
        new WebDriverWait(driver, 20)
                .until(ExpectedConditions.visibilityOf(fabAdd));
        return fabAdd.isDisplayed();
    }

    public EditCreateEventScreen initCreationEvent(){
        fabAdd.click();
        fabAddEvent.click();
        return new EditCreateEventScreen(driver);
    }



}
