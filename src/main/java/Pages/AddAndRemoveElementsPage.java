package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AddAndRemoveElementsPage {
    WebDriver driver;

    public AddAndRemoveElementsPage(WebDriver driver) {
        this.driver = driver;
    }

    private By addElementButton = By.xpath("//div[@class='example']/button");
    private By elements = By.xpath("//div[@class='example']/div[@id='elements']/button");
    private By firstElement = By.xpath("//div[@class='example']/div[@id='elements']//button[1]");

    public AddAndRemoveElementsPage clickOnAddElementButton(){
        driver.findElement(addElementButton).click();
        return this;
    }

    public AddAndRemoveElementsPage removeFirstElement(){
        driver.findElement(firstElement).click();
        return this;
    }

    public int getTheNumberOfItems(){
        List<WebElement> webElementList = driver.findElements(elements);
        return webElementList.size();
    }

}
