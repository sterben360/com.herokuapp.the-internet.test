package Pages;

import json.JsonReader;
import json.Request;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.List;

public class IFramePage {

    WebDriver driver;
    Request request;
    JsonReader reader;

    public IFramePage(WebDriver driver) {
        this.driver = driver;
    }

    private By textField = By.xpath("//iframe[@id='mce_0_ifr']");

    public IFramePage insertSomeText(String text){
        driver.findElement(textField).sendKeys(text + "\n");
        return this;
    }

    public String doGetRequest(String json) throws IOException {
        request = new Request();
        return request.getRequest(json);
    }

    public List<String> getTitlesList(String json) throws IOException {
        String strJson = this.doGetRequest(json);
        reader = new JsonReader();

        return reader.getTitles(strJson);
    }

    public IFramePage insertAllTitles(List<String> titles){
        for(String str : titles){
            this.insertSomeText(str);
        }
        return this;
    }
}
