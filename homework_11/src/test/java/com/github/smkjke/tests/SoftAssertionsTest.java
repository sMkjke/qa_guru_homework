package com.github.smkjke.tests;

import com.github.smkjke.BaseTest;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class SoftAssertionsTest extends BaseTest {

    @Test
    public void checkPageHaveAnJUnit5CodeTest() {
        open("/selenide/selenide");
        $x(".//a[@id='wiki-tab']").click();
        $x(".//input[@id='wiki-pages-filter']").setValue("SoftAssertions").pressEnter();
        $$x(".//details[@class='details-reset']").findBy(visible).shouldBe(text("SoftAssertions")).click();
        $x(".//a[contains(@id,'junit5')]/parent::h4").shouldHave(text("3. Using JUnit5 extend test class:"));
    }

}
