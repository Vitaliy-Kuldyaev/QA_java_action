package actions;

import Interfaces.SaveData;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;
import org.testng.Assert;

import static base.BaseTest.idThread;

public class Action implements SaveData {

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

    @Step("Проверка \"{se}\" на {condition}")
    public Action save(String value, String key) {
        SaveData.save(idThread.get(),key,value);
        return this;
    }

    @Step("Проверка Equals")
    public Action assertEquals(Object in, Object out) {
        Assert.assertEquals(in,out);
        return this;
    }
}
