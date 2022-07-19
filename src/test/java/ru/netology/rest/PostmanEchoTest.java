package ru.netology.rest;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

public class PostmanEchoTest {
    @Test
    void shouldPostToPostman() {
        given()
                .baseUri("https://postman-echo.com")
                .body("some data") // отправляемые данные (заголовки и query можно выставлять аналогично)
// Выполняемые действия
                .when()
                .post("/post")
// Проверки
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("data", equalTo("some data"))
        ;
    }

    @Test
    void shouldReturnCurrency() {
        given()
                .baseUri("https://postman-echo.com")
                .body("currency:USD")
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("data", equalTo("currency:USD"));
    }

    @Test
    void shouldReturnId() {
        given()
                .baseUri("https://postman-echo.com")
                .body("id:2")
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("data", equalTo("id:2"));
    }
}
