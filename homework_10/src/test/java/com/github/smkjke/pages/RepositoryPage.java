package com.github.smkjke.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$x;
import static com.github.smkjke.BaseTest.SMKJKE_QA_GURU_HOMEWORK;

public class RepositoryPage {

    private final SelenideElement expectedRepositoryElement = $x(".//a[@href='/sMkjke/qa_guru_homework']");
    private final SelenideElement issuesTabElement = $x(".//a[@id='issues-tab']");
    private final SelenideElement searchedIssueElement = $x(".//a[@id='issue_1_link']");

    public RepositoryPage clickOnIssuesTab() {
        issuesTabElement.click();
        return this;
    }

    public RepositoryPage checkIssueName(String name) {
        searchedIssueElement.shouldHave(text(name));
        return this;
    }

    public RepositoryPage checkPage() {
        expectedRepositoryElement.shouldHave(text(SMKJKE_QA_GURU_HOMEWORK));
        return this;
    }

}
