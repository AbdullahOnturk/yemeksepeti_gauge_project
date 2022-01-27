package Pages;


import Utils.DriverFactory;
import com.thoughtworks.gauge.Step;
import io.appium.java_client.MobileElement;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginPage extends DriverFactory {

    public static WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 10);

    public MobileElement waitForId(String Id) {
        MobileElement mobileElement = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(Id)));
        return mobileElement;
    }

    public void waitForElementToBeClickable(MobileElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    @Step("<id> id sine tıklanır.")
    public void onClickId(String id) throws InterruptedException {
        System.out.println(id + " alanın id'sine tıklama işlemina başlanır!!!");
        MobileElement element = (MobileElement) getDriver().findElementById(id);
        if (!element.isDisplayed()) {
            Assert.fail(id + " -> Elementi bulunamadı.");
        }
        try {
            waitForElementToBeClickable(element);
        } catch (Exception ex) {
            Assert.fail(id + " -> Elementi tıklanabilir değil!");
        }
        element.click();
    }

    @Step("<xpath_ine> xpath ine tıklanır.")
    public void onClickXpath(String xpath) throws InterruptedException {

        System.out.println(xpath + " alanın xpath'ine tıklama işlemina başlanır!!!");
        MobileElement element = (MobileElement) getDriver().findElementByXPath(xpath);
        if (!element.isDisplayed()) {
            Assert.fail(xpath + " -> Elementi bulunamadı!!!!!!!!!!!!!!");
        }
        try {
            waitForElementToBeClickable(element);
        } catch (Exception ex) {
            Assert.fail(xpath + " -> Elementi tıklanabilir değil!");
        }
        element.click();
    }

    @Step("<id> id alanına <text> yazılır.")
    public void sendKeys(String id, String text) {
        MobileElement element = (MobileElement) getDriver().findElementById(id);
        if (!element.isDisplayed()) {
            Assert.fail(id + " -> Elementi bulunamadı.");
        }
        try {
            waitForElementToBeClickable(element);
        } catch (Exception ex) {
            Assert.fail(id + " -> Elementi tıklanabilir değil!");
        }
        element.sendKeys(text);
    }


    @Step("<id> id alanında <text> yazdığı kontrol edilir.")
    public void assertEqualsId(String id, String text) {
        Assert.assertEquals(waitForId(id).getText(), text);
    }
}
