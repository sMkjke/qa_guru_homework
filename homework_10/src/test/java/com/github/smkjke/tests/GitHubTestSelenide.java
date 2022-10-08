package com.github.smkjke.tests;

import com.github.smkjke.BaseTest;
import com.github.smkjke.pages.MainPage;
import com.github.smkjke.pages.RepositoryPage;
import com.github.smkjke.pages.SearchRepositoryPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GitHubTestSelenide extends BaseTest {

    private final MainPage mainPage = new MainPage();
    private final SearchRepositoryPage searchRepositoryPage = new SearchRepositoryPage();
    private final RepositoryPage repositoryPage = new RepositoryPage();

    @Test
    @DisplayName("Selenide test")
    public void issueNameCheckTest() {
        mainPage.openPage().checkPage().searchClick().searchRepository(SMKJKE_QA_GURU_HOMEWORK).submit();
        searchRepositoryPage.checkPage().clickOnSearchRepository();
        repositoryPage.checkPage().clickOnIssuesTab().checkIssueName(ISSUE_NAME);
    }

}
