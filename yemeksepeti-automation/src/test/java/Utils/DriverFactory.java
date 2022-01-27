package Utils;

import com.thoughtworks.gauge.AfterScenario;
import com.thoughtworks.gauge.BeforeScenario;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;


public class DriverFactory {
    public static AppiumDriver appiumDriver;


    public void setup() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "52005285b631a40d");
        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "8.0");
        caps.setCapability("skipUnlock", "true");
        caps.setCapability("appPackage", "com.inovel.app.yemeksepeti");
        caps.setCapability("appActivity", "com.inovel.app.yemeksepeti.ui.splash.SplashActivity");
        caps.setCapability("noReset", "false");
        appiumDriver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        appiumDriver.manage().timeouts().implicitlyWait(3000L, TimeUnit.SECONDS);
    }

    public static AppiumDriver getDriver() {
        return appiumDriver;
    }

    @BeforeScenario
    public void setUpSettings() {
        try {
            setup();
        } catch (MalformedURLException e) {
            Assertions.fail("Fail due to the appium server error");
        }
    }

    @AfterScenario
    public static void tearDown() {
        getDriver().quit();
    }
}
