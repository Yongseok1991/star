package com.erp.star.com.user;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class KwareUserControllerTest {
    @Autowired
    KwareUserService service;
    @Test
    void test() {
        List<KwareUser> userList = service.findAll();
        userList.forEach(System.out::println);
    }
}
