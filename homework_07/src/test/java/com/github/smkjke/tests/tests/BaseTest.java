package com.github.smkjke.tests.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;

public class BaseTest {

    @BeforeEach
    void setUp() {
        Configuration.baseUrl = "https://ostrovok.ru";
//        Configuration.browserSize = "1920x1080";
    }

}
