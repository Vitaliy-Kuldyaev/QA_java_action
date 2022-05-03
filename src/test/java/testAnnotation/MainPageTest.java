package testAnnotation;

import base.BaseTest;
import io.qameta.allure.Link;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;
import utils.steps.Group.MainPageSteps;
import static com.codeborne.selenide.Condition.exist;

public class MainPageTest extends BaseTest {

    @Test(description = "11 Проверка табу 'Доходы' при заведении сделки менеджером УПРПП")
    @TmsLink("327247")
    @Link(type = "manual", value = "327247")
    public void navigationToAllTools() {
        ACTIONS_.open("https://www.jetbrains.com/")
                .click(MAIN_PAGE.searchButton)
                .step(MainPageSteps.clickToSearchButton())
                .save("noojijijoiopo","id")
                .check(MAIN_PAGE.searchButtonIcon, exist)
                .assertEquals(getValue("id"),"noojijijoiopo");

        int okj=0;
    }

    @Test(description = "11 Проверка табу 'Доходы' при заведении сделки менеджером УПРПП")
    @TmsLink("327247")
    @Link(type = "manual", value = "327247")
    public void navigationToAllTools2() {
        ACTIONS_.open("https://www.jetbrains.com/")
                //.click(MAIN_PAGE.searchButton)
                .step(MainPageSteps.clickToSearchButton())
                .save("noojijijoiopo","id")
                .check(MAIN_PAGE.searchButtonIcon, exist)
                .assertEquals(getValue("id"),"noojijijoiopo");

        int okj=0;
    }
}

