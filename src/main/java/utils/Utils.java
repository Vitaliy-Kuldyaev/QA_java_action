package utils;


import base.BaseTest;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import stands.Stands;
import utils.saveData.SaveDataInThread;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class Utils extends BaseTest {
    public static void execQuery(String query, Object... params) {
        DB.connect(Stands.getActiveStand()).setAutoCommit(true);
        DB.exec(query, params);
        DB.disconnect();
    }

    public static List<Map> doSelect(String query) {
        DB.connect(Stands.getActiveStand()).setAutoCommit(true);
        List<Map> result = DB.findAll(query);
        DB.disconnect();
        return result;
    }

    @Step("Получение промежуточных данных по ключу \"{key}\"")
    public static String getSave(String key) {
        return SaveDataInThread.getSaveValue(key);
    }

    public static boolean isClickable(SelenideElement se)
    {
        try
        {
            WebDriverWait wait = new WebDriverWait(getWebDriver(), Duration.ofMillis(5000));
            wait.until(ExpectedConditions.elementToBeClickable(se));
            return true;
        }
        catch (ElementClickInterceptedException e)
        {
            return false;
        }
    }
}
