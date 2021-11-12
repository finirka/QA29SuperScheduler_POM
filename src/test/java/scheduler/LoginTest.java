package scheduler;

import configuration.ConfigScheduler;
import dto.Credentials;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginScreen;
import pages.SplashScreem;

public class LoginTest extends ConfigScheduler {

    @Test
    public void loginTest(){

        boolean isFabPresent =
                new SplashScreem(driver)
                .checkVersion("0.0.3")
                .fillEmail("john235@gmail.com")
                .fillPassword("Jj12345$")
                .clickLoginButton()
                .skipWizard()
                .isFabAddButtonPresent();

        Assert.assertTrue(isFabPresent);
    }

    @Test
    public void loginComplex(){
        Credentials credentials = Credentials.builder()
                .email("john236@gmail.com")
                .password("Jj12345$")
                .build();
        boolean isFabPresent = new LoginScreen(driver)
                .loginComplex(credentials)
                .skipWizard()
                .isFabAddButtonPresent();
        Assert.assertTrue(isFabPresent);
    }

}
