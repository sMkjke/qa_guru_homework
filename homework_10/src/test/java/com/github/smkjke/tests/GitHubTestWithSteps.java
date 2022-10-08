package com.github.smkjke.tests;

import com.github.smkjke.BaseTest;
import com.github.smkjke.steps.MainPageSteps;
import com.github.smkjke.steps.RepositoryPageSteps;
import com.github.smkjke.steps.SearchRepositoryPageSteps;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GitHubTestWithSteps extends BaseTest {

    private final MainPageSteps mainPageSteps = new MainPageSteps();
    private final RepositoryPageSteps repositoryPageSteps = new RepositoryPageSteps();
    private final SearchRepositoryPageSteps searchRepositoryPageSteps = new SearchRepositoryPageSteps();

    @Test
    @DisplayName("Steps test")
    public void stepsIssueNameCheckTest(){
        mainPageSteps.openPage();
        mainPageSteps.checkPage();
        mainPageSteps.searchRepository(SMKJKE_QA_GURU_HOMEWORK);
        searchRepositoryPageSteps.clickOnRepositorySearchResult();
        searchRepositoryPageSteps.checkPage();
        repositoryPageSteps.checkPage();
        repositoryPageSteps.clickOnIssuesTab();
        repositoryPageSteps.checkIssueTitle(ISSUE_NAME);
    }

}
