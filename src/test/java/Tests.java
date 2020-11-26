import Pages.AddAndRemoveElementsPage;
import Pages.JSAlertsPage;
import Pages.MainPage;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Tests {

    WebDriver driver;
    MainPage mainPage;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        mainPage = new MainPage(driver);
    }

    @Test
    public void addAndRemoveElementsTest(){
        System.out.println("Step 1: going to main page");
        driver.get("http://the-internet.herokuapp.com/");

        System.out.println("Step 2: going to testing page");
        AddAndRemoveElementsPage elementsPage = mainPage.clickOnAddAndRemoveElementsLink();

        System.out.println("Step 3: adding three elements");
        elementsPage.clickOnAddElementButton();
        elementsPage.clickOnAddElementButton();
        elementsPage.clickOnAddElementButton();

        int num = elementsPage.getTheNumberOfItems();

        System.out.println("Step 4: checking for added elements");
        Assert.assertEquals(3,num);

        System.out.println("Step 5: remove some element");
        elementsPage.removeFirstElement();

        num = elementsPage.getTheNumberOfItems();

        System.out.println("Step 6: checking for removed element");
        Assert.assertEquals(2, num);
    }

    @Test
    public void alertsTest(){

        driver.get("http://the-internet.herokuapp.com/");

        JSAlertsPage jsAlertsPage = mainPage.clickOnJSAllertsLink();

        jsAlertsPage.clickAlertButton().clickOkOnJSAlert();

        String str = jsAlertsPage.getResultMessage();

        Assert.assertEquals("You successfuly clicked an alert", str);

        jsAlertsPage.clickJSConfirmButton().clickCancelOnJSAlert();

        str = jsAlertsPage.getResultMessage();
        Assert.assertEquals("You clicked: Cancel", str);

        jsAlertsPage.clickJSPromptButton().putSomeTextInJSPrompt("lmao").clickOkOnJSAlert();

        str = jsAlertsPage.getResultMessage();
        Assert.assertEquals("You entered: lmao", str);
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
