package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    private By addAndRemoveElementsLink = By.xpath("//a[text()='Add/Remove Elements']");
    private By jsAlertsPage = By.xpath("//a[text()='JavaScript Alerts']");

    public AddAndRemoveElementsPage clickOnAddAndRemoveElementsLink(){
        driver.findElement(addAndRemoveElementsLink).click();
        return new AddAndRemoveElementsPage(driver);
    }

    public JSAlertsPage clickOnJSAllertsLink(){
        driver.findElement(jsAlertsPage).click();
        return new JSAlertsPage(driver);
    }
}
