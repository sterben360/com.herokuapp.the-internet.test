package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UploadFilePage {

    WebDriver driver;

    public UploadFilePage(WebDriver driver) {
        this.driver = driver;
    }

    private By uploadFileButton = By.xpath("//input[@type='file']");
    private By submitButton = By.xpath("//input[@id='file-submit']");
    private By resultText = By.xpath("//div[@class='example']/h3");

    public UploadFilePage uploadSomeFile(String path){
        driver.findElement(uploadFileButton).sendKeys(path);
        return this;
    }

    public UploadFilePage clickOnSubmitButton(){
        driver.findElement(submitButton).click();
        return this;
    }

    public String getResultText(){
        return driver.findElement(resultText).getText();
    }

}
