package com.github.smkjke.tests.tests;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.SelenideElement;
import com.github.smkjke.tests.testData.enums.Locale;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class OstrovokWebTest extends BaseTest {

    public static final String LOG_IN_ENGLISH = "Log in";
    public static final String LOG_IN_DEUTSCH = "Anmelden";
    public static final String LOG_IN_ITALIANO = "Accedi";
    public static final String ASK_A_QUESTION_ENGLISH = "Ask a question";
    public static final String ASK_A_QUESTION_DEUTSCH = "Eine Frage stellen";
    public static final String ASK_A_QUESTION_ITALIANO = "Fare una domanda";


    @DisplayName("Check -ask a question button locale")
    @MethodSource("shouldReturnListOfMainMenuWithLocale")
    @ParameterizedTest(name = "Check displayed menu -Ask a question with {0} locale")
    public void checkAskAQuestionButtonLocaleTest(Locale locale, String menuText) {
        open("/");
        $x(".//div[contains(@class,'LanguageWidget-module__arrow--3_2Gi')]").click();
        $x(String.format(".//div[contains(text(),'%s')]/parent::div", locale.name())).click();
        $$x(".//div[contains(@class,'SupportWidget-module__value--2rcOQ')]")
                .shouldHave(CollectionCondition.texts(menuText));


    }

    static Stream<Arguments> shouldReturnListOfMainMenuWithLocale() {
        return Stream.of(
                Arguments.of(Locale.English, ASK_A_QUESTION_ENGLISH),
                Arguments.of(Locale.Deutsch, ASK_A_QUESTION_DEUTSCH),
                Arguments.of(Locale.Italiano, ASK_A_QUESTION_ITALIANO)
        );
    }

    @EnumSource(Locale.class)
    @DisplayName("Check -log in button locale")
    @ParameterizedTest(name = "Check displayed menu -Log in with {0} locale")
    void checkLogInButtonLocaleTest(Locale locale) {
        open("/");
        $x(".//div[contains(@class,'LanguageWidget-module__arrow--3_2Gi')]").click();
        $x(String.format(".//div[contains(text(),'%s')]/parent::div", locale.name())).click();
        SelenideElement element = $x(".//div[contains(@class,'Control-module__value--1KWj3')]");
        switch (locale.name()) {
            case ("English") -> assertEquals(LOG_IN_ENGLISH, element.text());
            case ("Deutsch") -> assertEquals(LOG_IN_DEUTSCH, element.text());
            case ("Italiano") -> assertEquals(LOG_IN_ITALIANO, element.text());
        }
    }

    @ValueSource(strings = {"About Ostrovok.ru", "Save a new promo code", "Customer Support"})
    @DisplayName("Check main menu positions")
    @ParameterizedTest(name = "Check main menu {0} text")
    void checkMainMenuPositionsTest(String menu) {
        open("/");
        $x(".//div[contains(@class,'LanguageWidget-module__arrow--3_2Gi')]").click();
        $x(".//div[contains(text(),'English')]/parent::div").click();
        $x(".//div[contains(@class,'MenuWidget-module__button--2_XeY')]").click();
        $x(String.format(".//div[contains(@class,'MenuWidget-module__link--1lgVQ')]/*[contains(text(),'%s')]", menu))
                .shouldHave(visible, text(menu));
    }
}
