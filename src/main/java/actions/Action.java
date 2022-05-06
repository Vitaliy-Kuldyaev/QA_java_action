package actions;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;
import org.testng.Assert;
import steps.Group.Steps;
import utils.saveData.SaveDataInThread;

public class Action {

    @Step("Авторизация на стенде")
    public Action authorise(String user) {
        return this;
    }

    @Step("Открытие страницы \"{url}\"")
    public Action open(String url) {
        WebDriverRunner.getWebDriver().get(url);
        return this;
    }

    public Action click(SelenideElement se) {
        //se.shouldBe(visible).click();
        se.click();
        return this;
    }

    @Step("Проверка \"{se}\" на {condition}")
    public Action check(SelenideElement se, Condition condition) {
        se.scrollTo();
        se.shouldBe(condition);
        return this;
    }

    @Step("Cохранение промежуточных данных \"{value}\" в \"{key}\"")
    public Action save(String value, String key) {
        SaveDataInThread.saveValue(key,value);
        return this;
    }

    @Step("Проверка Equals")
    public Action assertEquals(Object in, Object out) {
        Assert.assertEquals(in,out);
        return this;
    }

    @Step("Проверка Equals")
    public Action step(Steps steps)  {
        return this;
    }

    public Action wait(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }
}
