package utils.steps.Group;

import actions.Action;

import page.MainPage;
import utils.steps.Steps;

public class MainPageSteps extends Steps {

    public static MainPageSteps clickToSearchButton() {
        Action ACTIONS = new Action();
        MainPage MAIN_PAGE = new MainPage();
        ACTIONS.click(MAIN_PAGE.searchButton);
        return null;
    }


}

