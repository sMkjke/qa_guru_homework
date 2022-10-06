package com.github.smkjke.tests.tests;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.smkjke.testData.Users;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

public class JsonParseTest {
    public static final File JSON_TEST_FILE = new File("src/test/resources/test.json");

    @Test
    void jsonParseFirstNameValueCheckTest() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Users users = objectMapper.readValue(JSON_TEST_FILE, Users.class);

        String expectedName = "Aleksey";
        assertThat(users.getUsers().get(0).getFirstName()).isEqualTo(expectedName);
    }

    @Test
    public void jsonParseUsersSizeCheckTest() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Users users = objectMapper.readValue(JSON_TEST_FILE, Users.class);

        int expectedSize = 5;
        assertThat(users.getUsers().size()).isEqualTo(expectedSize);
    }

    @Test
    public void jsonParseUserPetCheckTest() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Users users = objectMapper.readValue(JSON_TEST_FILE, Users.class);

        String expectedPet = "hamster";
        assertThat(users.getUsers().get(4).getPets().get(1)).isEqualTo(expectedPet);
    }


}
