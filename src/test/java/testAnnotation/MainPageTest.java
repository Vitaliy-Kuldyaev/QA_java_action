package testAnnotation;

import base.BaseTest;
import io.qameta.allure.Link;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;
import stands.Stands;
import steps.Group.MainPageSteps;

import static utils.Utils.*;

public class MainPageTest extends BaseTest {
    @Test(description = "11 Проверка табу 'Доходы' при заведении сделки менеджером УПРПП")
    @TmsLink("327247")
    @Link(type = "manual", value = "327247")
    public void test1() {
        ACTIONS_.authorise("Administrator")
                .open(Stands.getActiveStand().getWebURL())
                //.click(MAIN_PAGE.searchButton)
                .step(MainPageSteps.clickToSearchButton())
                .save("123","id")
                //.check(MAIN_PAGE.searchButtonIcon, exist)
                .assertEquals(getSave("id"),"123")
                .wait(1000)
                .assertEquals(getSave("id"),"123")
                .wait(1000)
                .assertEquals(getSave("id"),"123")
                .wait(1000)
                .assertEquals(getSave("id"),"123")
                .wait(1000);
    }

    @Test(description = "12 Проверка табу 'Доходы' при заведении сделки менеджером УПРПП")
    @TmsLink("327247")
    @Link(type = "manual", value = "327247")
    public void test2() {
        ACTIONS_.open("https://www.jetbrains.com/")
                //.click(MAIN_PAGE.searchButton)
                .step(MainPageSteps.clickToSearchButton())
                .save("234","id")
                //.check(MAIN_PAGE.searchButtonIcon, exist)
                .assertEquals(getSave("id"),"234")
                .wait(1000)
                .assertEquals(getSave("id"),"234")
                .wait(1000)
                .assertEquals(getSave("id"),"234")
                .wait(1000)
                .assertEquals(getSave("id"),"2234")
                .wait(1000);
    }

    @Test(description = "13 Проверка табу 'Доходы' при заведении сделки менеджером УПРПП")
    @TmsLink("327247")
    @Link(type = "manual", value = "327247")
    public void test3() {
        ACTIONS_.open("https://www.jetbrains.com/")
                //.click(MAIN_PAGE.searchButton)
                .step(MainPageSteps.clickToSearchButton())
                .save("345","id")
                //.check(MAIN_PAGE.searchButtonIcon, exist)
                .assertEquals(getSave("id"),"345")
                .wait(1000)
                .assertEquals(getSave("id"),"345")
                .wait(1000)
                .assertEquals(getSave("id"),"345")
                .wait(1000)
                .assertEquals(getSave("id"),"345")
                .wait(1000);
    }

    @Test(description = "14 Проверка табу 'Доходы' при заведении сделки менеджером УПРПП")
    @TmsLink("327247")
    @Link(type = "manual", value = "327247")
    public void test4() {
        ACTIONS_.open("https://www.jetbrains.com/")
                //.click(MAIN_PAGE.searchButton)
                .step(MainPageSteps.clickToSearchButton())
                .save("456","id")
                //.check(MAIN_PAGE.searchButtonIcon, exist)
                .assertEquals(getSave("id"),"456")
                .wait(1000)
                .assertEquals(getSave("id"),"456")
                .wait(1000)
                .assertEquals(getSave("id"),"456")
                .wait(1000)
                .assertEquals(getSave("id"),"456")
                .wait(1000);
    }
}

