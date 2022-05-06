package actions;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;
import org.testng.Assert;
import steps.Group.Steps;
import utils.saveData.SaveDataInThread;

import java.time.Duration;

import static utils.Utils.isClickable;

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
        clickAction(se, false);
        return this;
    }

    private void clickAction(SelenideElement se, Boolean waitPageReload) {
        waitUntil(se, 10000);
        //se.scrollIntoView(true);
        scrollToCenter(se);
        try {
            se.shouldBe(Condition.visible);
        } catch (Throwable ignored) {
        }
        ;
        click(se, se.getText());
        if (waitPageReload) {
            //
        }
    }

    /**
     * Клик на передаваемый элемент. Этот клик используется при нажатии на элементы без текста внутри.
     *
     * @param se          SelenideElement на который делается клик.
     * @param elementName название элемента, отображаемое в отчете прогона.
     */
    @Step("Нажатие на \"{elementName}\"")
    public Action click(SelenideElement se, String elementName) {
        if (isClickable(se)) {
            try {
                se.click();
            } catch (Throwable e) {
                clickJS(se);
            }
        } else {
            clickJS(se);
        }
        return this;
    }

    /**
     * Простой клик на передаваемый элемент se через JS.
     */
    public Action clickJS(SelenideElement se) {
        waitUntil(se, 10000);
        Selenide.executeJavaScript("arguments[0].click();", se.getWrappedElement());
        wait(100);
        return this;
    }

    /**
     * Ожидание наступления определенного состояния элемента в html дереве в течение передаваемого времени
     */
    @Step("Ожидание условия на протяжении {timeInMillis}")
    public Action waitUntil(SelenideElement se, Condition condition, long timeInMillis) {
        se.shouldBe(condition, (Duration.ofMillis(timeInMillis)));
        return this;
    }

    /**
     * Ожидание наступления состояния Exist элемента в html дереве в течение передаваемого времени
     */
    @Step("Ожидание элемента на протяжении {timeInMillis}")
    public Action waitUntil(SelenideElement se, long timeInMillis) {
        se.shouldBe(Condition.exist, (Duration.ofMillis(timeInMillis)));
        return this;
    }

    /**
     * скролл до передаваемого элемента в центр экрана
     */
    public Action scrollToCenter(SelenideElement se) {
        waitUntil(se, Condition.enabled, 5000);
        se.scrollIntoView("{behavior: \"auto\", block: \"center\", inline: \"center\"}");
        wait(100);
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
        SaveDataInThread.saveValue(key, value);
        return this;
    }

    @Step("Проверка Equals")
    public Action assertEquals(Object in, Object out) {
        Assert.assertEquals(in, out);
        return this;
    }

    @Step("Проверка Equals")
    public Action step(Steps steps) {
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
