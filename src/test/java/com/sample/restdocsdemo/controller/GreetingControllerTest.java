package com.sample.restdocsdemo.controller;

import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.requestFields;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.restdocs.webtestclient.WebTestClientRestDocumentation.document;
import static org.springframework.restdocs.webtestclient.WebTestClientRestDocumentation.documentationConfiguration;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.restdocs.RestDocumentationContextProvider;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.sample.restdocsdemo.model.Greeting;
import com.sample.restdocsdemo.model.User;

import reactor.core.publisher.Mono;

@SpringBootTest
@ExtendWith( {RestDocumentationExtension.class, SpringExtension.class})
class GreetingControllerTest {

    private WebTestClient webTestClient;

    @BeforeEach
    void setUp(ApplicationContext applicationContext,
        RestDocumentationContextProvider restDocumentation) {
        this.webTestClient = WebTestClient.bindToApplicationContext(applicationContext)
                                 .configureClient()
                                 .filter(documentationConfiguration(restDocumentation))
                                 .build();
    }

    @Test
    void hello_greeting() {
        this.webTestClient.post().uri("/greeting").body(Mono.just(new User("Test", "Test@abc.com")), User.class).accept(MediaType.APPLICATION_JSON)
            .exchange().expectStatus().isOk()
            .expectBody(Greeting.class)
            .consumeWith(document("{method-name}/", requestFields(
                fieldWithPath("name").description("User's name"),
                fieldWithPath("email").description("User's email")
            ), responseFields(
                fieldWithPath("greetingMessage").description("Greeting message")
            )));


    }

}