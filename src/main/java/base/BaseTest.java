package base;

import Interfaces.SaveData;
import actions.Action;
import Interfaces.ProjectConfig;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import database.PGBase;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;
import page.MainPage;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.logging.Logger;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.webdriver;
import static org.testng.Assert.assertEquals;

public class BaseTest implements SaveData {
    public static final Logger LOGGER = Logger.getLogger("TEST LOGGER");
    public static final PGBase DB = new PGBase();
    public MainPage MAIN_PAGE;
    public Action ACTIONS_;
    public ProjectConfig config;
    public static ThreadLocal<Long> idThread = new ThreadLocal<>();

    @BeforeSuite
    public void setProjectVariable() {
        WebDriverManager.chromedriver().setup();
        //Injector.inject(this) ;
        Field[] fields = this.getClass().asSubclass(this.getClass()).getDeclaredFields();
        for(Field field : fields) {
            //edited this line for test purposes
            System.out.println(field.getName());
        }
/*        Class<doParams> obj = doParams.class;
        // Обработка аннотации @Source
        if (obj.isAnnotationPresent(Source.class)) {
            Annotation source = obj.getAnnotation(Source.class);
            Source sourceData = (Source) source;
            System.out.println(sourceData.value());
        }*/
    }

    @BeforeClass
    public static void setUpAll() {
        Configuration.browserSize = "1920x1080";
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeMethod
    protected void setUp(Method method) {
        // ThreadLocal variable for method ACTION.save
        idThread.set(System.currentTimeMillis());
        ProjectConfig config;
        //System.out.println(config.appUrl().toString());
        //assertEquals(config.appUrl(),"http:\\\\ya.ru" );

        // WebDriver activate
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-web-security");
        options.addArguments("--allow-running-insecure-content");
        options.addArguments("--ignore-certificate-errors");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        WebDriverRunner.setWebDriver(driver);
        //WebDriverRunner.getWebDriver().get("https://www.jetbrains.com/");
/*
        // Selenoid WebDriver activate
            try {
                WebDriver driver = new RemoteWebDriver(URI.create("http://gausapppre201l:4444/wd/hub").toURL(), dc);
                driver.manage().window().maximize();
                driver.get(Gauss.getActiveStand().getWebURL());
                TEST_DATA.createDefaultFullDeal_UI();
                driver.close();
                driver.quit();
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }*/


        ACTIONS_ = new Action();
        MAIN_PAGE = new MainPage();
    }

    @AfterTest
    protected void teardown() {
        WebDriverRunner.getWebDriver().quit();
    }
}
