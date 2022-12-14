package com.github.smkjke;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeEach;

public class BaseTest {

    public static final String SMKJKE_QA_GURU_HOMEWORK = "sMkjke/qa_guru_homework";
    public static final String ISSUE_NAME = "New Test Issue";


    @BeforeEach
    void setUp() {
        Configuration.baseUrl = "https://github.com";
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

}
