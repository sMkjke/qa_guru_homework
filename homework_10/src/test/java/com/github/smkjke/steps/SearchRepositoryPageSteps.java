package com.github.smkjke.steps;

import com.github.smkjke.pages.SearchRepositoryPage;
import io.qameta.allure.Step;

public class SearchRepositoryPageSteps {
    private final SearchRepositoryPage searchRepositoryPage = new SearchRepositoryPage();


    @Step("Click on searched result")
    public void clickOnRepositorySearchResult(){
        searchRepositoryPage.clickOnSearchRepository();
    }

    @Step("Check that Search page was opened")
    public void checkPage() {
        searchRepositoryPage.checkPage();
    }
}
