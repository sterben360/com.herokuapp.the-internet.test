package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class JSAlertsPage {

    WebDriver driver;

    public JSAlertsPage(WebDriver driver) {
        this.driver = driver;
    }

    private By alertButton = By.xpath("//button[contains(text(),'Click for JS Alert')]");
    private By confirmButton = By.xpath("//button[contains(text(),'Click for JS Confirm')]");
    private By promptButton = By.xpath("//button[contains(text(),'Click for JS Prompt')]");
    private By resultMessage = By.xpath("//p[@id='result']");

    public JSAlertsPage clickAlertButton(){
        driver.findElement(alertButton).click();
        return this;
    }

    public JSAlertsPage clickJSConfirmButton(){
        driver.findElement(confirmButton).click();
        return this;
    }

    public JSAlertsPage clickJSPromptButton(){
        driver.findElement(promptButton).click();
        return this;
    }

    public JSAlertsPage clickCancelOnJSAlert(){
        driver.switchTo().alert().dismiss();
        return this;
    }

    public JSAlertsPage clickOkOnJSAlert(){
        driver.switchTo().alert().accept();
        return this;
    }

    public JSAlertsPage putSomeTextInJSPrompt(String text){
        driver.switchTo().alert().sendKeys(text);
        return this;
    }

    public String getResultMessage(){
        return driver.findElement(resultMessage).getText();
    }
}
