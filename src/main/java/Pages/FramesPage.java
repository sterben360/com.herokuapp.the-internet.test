package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FramesPage {

    WebDriver driver;

    public FramesPage(WebDriver driver) {
        this.driver = driver;
    }

    private By iFrameLink = By.xpath("//a[text()='iFrame']");

    public IFramePage clickOnIFrameLink(){
        driver.findElement(iFrameLink).click();
        return new IFramePage(driver);
    }
}
