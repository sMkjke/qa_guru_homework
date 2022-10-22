package com.github.smkjke;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;

public class BaseTest {

    @BeforeEach
    void setUp() {
        Configuration.baseUrl = "https://github.com";
    }

}
