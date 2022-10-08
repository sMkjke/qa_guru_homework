package com.github.smkjke.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class MainPage {

    private final SelenideElement mainSearchInput = $x(".//input[@aria-label='Search GitHub']");
    private final SelenideElement mainPageGreeting = $x(".//h1[contains(text(),\"Let's build from\")]");

    public MainPage openPage() {
        open("/");
        return this;
    }

    public MainPage searchRepository(String value) {
        mainSearchInput.setValue(value).pressEnter();
        return this;
    }

    public void submit() {
        mainSearchInput.submit();
    }

    public MainPage searchClick() {
        mainSearchInput.click();
        return this;
    }

    public MainPage checkPage(){
        mainPageGreeting.shouldHave(text("Let's build from"));
        return this;
    }

}
