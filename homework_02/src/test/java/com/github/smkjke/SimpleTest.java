package com.github.smkjke;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Random;

public class SimpleTest {

    @Test
    void exampleSimpleTest() {
        System.out.println("Github conflict check");
        Assertions.assertTrue(new Random().nextInt() > 3);
    }
}
