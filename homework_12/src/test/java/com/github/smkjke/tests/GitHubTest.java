package com.github.smkjke.tests;

import com.github.smkjke.BaseTest;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.$x;


public class GitHubTest extends BaseTest {

    @Test
    public void checkPageSolutionsEnterpriseShouldHaveText() {
        open("/");
        $$x(".//nav[@aria-label='Global']")
                .findBy(text("Solutions")).shouldBe(visible).hover()
                .$x(".//a[contains(text(),'Enterprise')]").shouldBe(visible).shouldHave(text("Enterprise")).click();
        $x(".//h4/following-sibling::h1").shouldHave(text("Build like the best"));
    }

}
