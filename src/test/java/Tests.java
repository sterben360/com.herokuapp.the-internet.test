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
        elementsPage.clickOnAddElementButton().clickOnAddElementButton().clickOnAddElementButton();

        System.out.println("Step 4: checking for added elements");
        Assert.assertEquals(3, elementsPage.getTheNumberOfItems());

        System.out.println("Step 5: remove some element");
        elementsPage.removeFirstElement();

        System.out.println("Step 6: checking for removed element");
        Assert.assertEquals(2, elementsPage.getTheNumberOfItems());
    }

    @Test
    public void alertsPageTest(){
        System.out.println("Step 1: going to main page");
        driver.get("http://the-internet.herokuapp.com/");

        System.out.println("Step 2: going to testing page");
        JSAlertsPage jsAlertsPage = mainPage.clickOnJSAllertsLink();

        System.out.println("Step 3: click on \"Click for JS Alert\" button and click \"OK\" on Alert");
        jsAlertsPage.clickAlertButton().clickOkOnJSAlert();

        System.out.println("Step 4: checking for a corresponding message");
        Assert.assertEquals("You successfuly clicked an alert", jsAlertsPage.getResultMessage());

        System.out.println("Step 5: click on \"Click for JS Confirm\" button and click \"Cancel\" on Alert");
        jsAlertsPage.clickJSConfirmButton().clickCancelOnJSAlert();

        System.out.println("Step 6: checking for a corresponding message");
        Assert.assertEquals("You clicked: Cancel", jsAlertsPage.getResultMessage());

        System.out.println("Step 7: click on \"Click for JS Prompt\" button, some text input and click \"OK\" on Alert");
        jsAlertsPage.clickJSPromptButton().insertSomeTextInJSPrompt("lmao").clickOkOnJSAlert();

        System.out.println("Step 8: checking for a corresponding message");
        Assert.assertEquals("You entered: lmao", jsAlertsPage.getResultMessage());
    }

    @Test
    public void iFramePageTest() throws IOException {
        String json = "http://jsonplaceholder.typicode.com/todos?_start=0&_limit=5";

        System.out.println("Step 1: going to main page");
        driver.get("http://the-internet.herokuapp.com/");

        System.out.println("Step 2: going to testing page");
        IFramePage iFramePage = mainPage.clickOnFramesLink().clickOnIFrameLink();

        System.out.println("Step 3: executing a get request and saving all titles");
        List<String> titles = iFramePage.getTitlesList(json);

        System.out.println("Step 4: entering all titles in the text field");
        iFramePage.insertAllTitles(titles);
    }

    @Test
    public void uploadFilePageTest(){
        System.out.println("Step 1: going to main page");
        driver.get("http://the-internet.herokuapp.com/");

        System.out.println("Step 2: going to testing page");
        UploadFilePage uploadFilePage = mainPage.clickOnUploadFileLink();

        System.out.println("Step 3: choosing a file to download");
        uploadFilePage.uploadSomeFile("C:\\imageForTest\\img.jpg");

        System.out.println("Step 4: click on \"Upload\" button");
        uploadFilePage.clickOnSubmitButton();

        System.out.println("Step 5: checking for a corresponding message");
        Assert.assertEquals("File Uploaded!", uploadFilePage.getResultText());
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
