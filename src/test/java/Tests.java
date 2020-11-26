import Pages.*;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.List;
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
    public void addAndRemoveElementsPageTest(){
        System.out.println("Step 1: going to main page");
        driver.get("http://the-internet.herokuapp.com/");

        System.out.println("Step 2: going to testing page");
        AddAndRemoveElementsPage elementsPage = mainPage.clickOnAddAndRemoveElementsLink();

        System.out.println("Step 3: adding three elements");
        elementsPage.clickOnAddElementButton();
        elementsPage.clickOnAddElementButton();
        elementsPage.clickOnAddElementButton();

        System.out.println("Step 4: checking for added elements");
        Assert.assertEquals(3, elementsPage.getTheNumberOfItems());

        System.out.println("Step 5: remove some element");
        elementsPage.removeFirstElement();

        System.out.println("Step 6: checking for removed element");
        Assert.assertEquals(2, elementsPage.getTheNumberOfItems());
    }

    @Test
    public void alertsPageTest(){
        driver.get("http://the-internet.herokuapp.com/");

        JSAlertsPage jsAlertsPage = mainPage.clickOnJSAllertsLink();

        jsAlertsPage.clickAlertButton().clickOkOnJSAlert();

        Assert.assertEquals("You successfuly clicked an alert", jsAlertsPage.getResultMessage());

        jsAlertsPage.clickJSConfirmButton().clickCancelOnJSAlert();

        Assert.assertEquals("You clicked: Cancel", jsAlertsPage.getResultMessage());

        jsAlertsPage.clickJSPromptButton().insertSomeTextInJSPrompt("lmao").clickOkOnJSAlert();

        Assert.assertEquals("You entered: lmao", jsAlertsPage.getResultMessage());
    }

    @Test
    public void iFramePageTest() throws IOException {
        String json = "http://jsonplaceholder.typicode.com/todos?_start=0&_limit=5";

        driver.get("http://the-internet.herokuapp.com/");

        IFramePage iFramePage = mainPage.clickOnFramesLink().clickOnIFrameLink();

        List<String> titles = iFramePage.getTitlesList(json);

        iFramePage.insertAllTitles(titles);
    }

    @Test
    public void uploadFilePageTest(){
        driver.get("http://the-internet.herokuapp.com/");

        UploadFilePage uploadFilePage = mainPage.clickOnUploadFileLink();

        uploadFilePage.uploadSomeFile("C:\\img.jpg");

        uploadFilePage.clickOnSubmitButton();

        Assert.assertEquals("File Uploaded!", uploadFilePage.getResultText());
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
