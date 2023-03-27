package com.rest.api.controller;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserControllerTest {

    @Autowired
    private UserController userController;

    @Test
    public void contextLoads() {
        assertThat(userController).isNotNull();
    }


}