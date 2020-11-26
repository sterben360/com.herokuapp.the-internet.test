package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    private By addAndRemoveElementsLink = By.xpath("//a[text()='Add/Remove Elements']");
    private By jsAlertsLink = By.xpath("//a[text()='JavaScript Alerts']");
    private By uploadFileLink = By.xpath("//a[text()='File Upload']");
    private By framesLink = By.xpath("//a[text()='Frames']");

    public AddAndRemoveElementsPage clickOnAddAndRemoveElementsLink(){
        driver.findElement(addAndRemoveElementsLink).click();
        return new AddAndRemoveElementsPage(driver);
    }

    public JSAlertsPage clickOnJSAllertsLink(){
        driver.findElement(jsAlertsLink).click();
        return new JSAlertsPage(driver);
    }

    public FramesPage clickOnFramesLink(){
        driver.findElement(framesLink).click();
        return new FramesPage(driver);
    }

    public UploadFilePage clickOnUploadFileLink(){
        driver.findElement(uploadFileLink).click();
        return new UploadFilePage(driver);
    }
}
