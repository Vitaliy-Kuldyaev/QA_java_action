package page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class MainPage {
    public SelenideElement seeAllToolsButton = $("a.wt-button_mode_primary");
    public SelenideElement toolsMenu = $x("//div[contains(@class, 'menu-main__item') and text() = 'Developer Tools']");
    public SelenideElement searchButton = $x("//button[text()='Продолжить']");
    public SelenideElement searchButtonIcon = $x("//button[@data-test='site-header-mobile-search-action']");
}
