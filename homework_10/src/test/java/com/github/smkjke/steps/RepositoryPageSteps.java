package com.github.smkjke.steps;

import com.github.smkjke.pages.RepositoryPage;
import io.qameta.allure.Step;

public class RepositoryPageSteps {

    private final RepositoryPage repositoryPage = new RepositoryPage();


    @Step("Check that Repository page was opened")
    public void checkPage() {
        repositoryPage.checkPage();
    }

    @Step("Click on tab issues")
    public void clickOnIssuesTab() {
        repositoryPage.clickOnIssuesTab();

    }

    @Step("Check issue name {value}")
    public void checkIssueTitle(String value) {
        repositoryPage.checkIssueName(value);
    }

}
