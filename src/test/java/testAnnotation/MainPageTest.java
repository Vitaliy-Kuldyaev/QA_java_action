package testAnnotation;

import base.BaseTest;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.exist;

public class MainPageTest extends BaseTest {
    @Test
    public void navigationToAllTools() {
        //MAIN_PAGE.searchButton.click();
        ACTIONS_.open("https://www.jetbrains.com/")
                .click(MAIN_PAGE.searchButton)
                .save("noojijijoiopo","id")
                .check(MAIN_PAGE.searchButtonIcon, exist)
                .assertEquals(getValue("id"),"noojijijoiopo");

        String dfgd = getValue("id");
        int okj=0;
    }
}

