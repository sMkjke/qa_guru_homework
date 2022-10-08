package com.github.smkjke.tests;

import com.github.smkjke.BaseTest;
import com.github.smkjke.pages.MainPage;
import com.github.smkjke.pages.RepositoryPage;
import com.github.smkjke.pages.SearchRepositoryPage;
import io.qameta.allure.Step;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class GitHubTestWithLambda extends BaseTest {

    private final MainPage mainPage = new MainPage();
    private final SearchRepositoryPage searchRepositoryPage = new SearchRepositoryPage();
    private final RepositoryPage repositoryPage = new RepositoryPage();

    @Test
    @DisplayName("Lambda test")
    public void lambdaIssueNameCheckTest() {
        step("Open the main page", () -> {
            mainPage.openPage();
        });
        step("Check that Main page was opened", () -> {
            mainPage.checkPage();
        });
        step("Find the repository " + SMKJKE_QA_GURU_HOMEWORK, () -> mainPage.searchClick().searchRepository(SMKJKE_QA_GURU_HOMEWORK).submit());
        step("Check that Search page was opened", () -> {
            searchRepositoryPage.checkPage();
        });
        step("Click on searched result", () -> {
            searchRepositoryPage.clickOnSearchRepository();
        });
        step("Check that Repository page was opened", () -> {
            repositoryPage.checkPage();
        });
        step("Click on tab issues", () -> {
            repositoryPage.clickOnIssuesTab();
        });
        step("Check issue name " + ISSUE_NAME, () -> {
            repositoryPage.checkIssueName(ISSUE_NAME);
        });
    }

}
