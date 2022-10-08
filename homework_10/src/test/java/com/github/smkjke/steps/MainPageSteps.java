package com.github.smkjke.steps;

import com.github.smkjke.pages.MainPage;
import io.qameta.allure.Step;

public class MainPageSteps {

    private final MainPage mainPage = new MainPage();

    @Step("Open the main page")
    public void openPage(){
        mainPage.openPage();
    }

    @Step("Check that Main page was opened")
    public void checkPage() {
        mainPage.checkPage();
    }

    @Step("Find the repository {value}")
    public void searchRepository(String value) {
        mainPage.searchClick().searchRepository(value).submit();
    }

}
