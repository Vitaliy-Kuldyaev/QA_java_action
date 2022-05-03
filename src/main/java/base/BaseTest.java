package base;

import Interfaces.SaveData;
import actions.Action;
import Interfaces.ProjectConfig;
import database.PGBase;
import org.testng.annotations.BeforeSuite;
import page.MainPage;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.logging.Logger;

import static com.codeborne.selenide.Selenide.open;
import static org.testng.Assert.assertEquals;

public class BaseTest implements SaveData {
    public static final Logger LOGGER = Logger.getLogger("TEST LOGGER");
    public static final PGBase DB = new PGBase();
    public MainPage MAIN_PAGE;
    public Action ACTIONS_;
    public ProjectConfig config;
    public ThreadLocal<Long> idThread = new ThreadLocal<>();
    @BeforeSuite
    public void setProjectVariable() {
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
        idThread.set(System.currentTimeMillis());
        ProjectConfig config;
        //System.out.println(config.appUrl().toString());
        //assertEquals(config.appUrl(),"http:\\\\ya.ru" );

        open("https://www.jetbrains.com/");
        ACTIONS_ = new Action();
        MAIN_PAGE = new MainPage();
    }


}
