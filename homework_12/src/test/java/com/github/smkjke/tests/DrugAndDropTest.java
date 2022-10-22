package com.github.smkjke.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class DrugAndDropTest {

    @BeforeEach
    void setUp() {
        Configuration.baseUrl = "https://the-internet.herokuapp.com";
    }

    @Test
    public void drugAndDropTest(){
            open("/drag_and_drop");
            $x(".//div[@id='column-a']")
                    .shouldBe(visible).dragAndDropTo("#column-b")
                    .shouldHave(text("B"));
    }
}
