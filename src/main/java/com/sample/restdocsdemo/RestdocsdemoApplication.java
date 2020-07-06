package com.sample.restdocsdemo;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

@SpringBootApplication
public class RestdocsdemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestdocsdemoApplication.class, args);
    }

    @Bean
    public RouterFunction<ServerResponse> indexRouter(@Value("classpath:/static/docs/greeting.html") final Resource indexHtml) {
        return route(GET("/docs"), request -> ok().contentType(MediaType.TEXT_HTML).syncBody(indexHtml));
    }

}
