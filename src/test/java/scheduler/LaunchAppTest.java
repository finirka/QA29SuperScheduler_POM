package scheduler;

import configuration.ConfigScheduler;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SplashScreem;

public class LaunchAppTest extends ConfigScheduler {

    @Test
    public void launchTest(){

        String version = new SplashScreem(driver).getCurrentVersion();

        Assert.assertEquals(version,"0.0.3");

    }
}
