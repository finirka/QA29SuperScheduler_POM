package scheduler;

import configuration.ConfigScheduler;
//import configuration.ListenTestNG;
import dto.Credentials;
import dto.Event;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.HomeScreen;
import pages.SplashScreem;

//@Listeners(ListenTestNG.class)
public class EventTest extends ConfigScheduler {

    @BeforeMethod
    public void precondition(){
        new SplashScreem(driver)
                .checkVersion("0.0.3")
                .loginComplex(Credentials.builder().email("john00155@gmail.com").password("Jj123456$").build())
                .skipWizard()
                .isFabAddButtonPresent();

    }

    @Test
    public void eventCreationTest(){
        boolean isFabPresent = new HomeScreen(driver)
                .initCreationEvent()
                .createNewEvent(Event.builder()
                        .title("New Event")
                        .type("event")
                        .breaks(3)
                        .amount(30)
                        .build())
                .isFabAddButtonPresent();


        Assert.assertTrue(isFabPresent);

    }
}
