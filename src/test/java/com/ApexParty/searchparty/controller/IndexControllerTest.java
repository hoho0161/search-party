package com.ApexParty.searchparty.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class IndexControllerTest {
    private TestRestTemplate restTemplate;

    @Autowired
    IndexControllerTest (TestRestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Test
    public void 메인페이지_로딩() {
        //when
        String body = this.restTemplate.getForObject("/",String.class);

        //then
        assertThat(body).contains("에이펙스 파티 찾기");
    }

}