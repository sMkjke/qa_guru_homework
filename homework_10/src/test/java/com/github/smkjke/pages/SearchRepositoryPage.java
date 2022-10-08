package com.github.smkjke.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$x;

public class SearchRepositoryPage {

    private final SelenideElement searchRepositoryResults = $x(".//div[@class='px-2']/div");
    private final SelenideElement searchRepositoryLink = $x(".//div[@class='f4 text-normal']");

    public SearchRepositoryPage clickOnSearchRepository() {
        searchRepositoryLink.click();
        return this;
    }

    public SearchRepositoryPage checkPage() {
        searchRepositoryResults.shouldHave(text("repository result"));
        return this;
    }

}
