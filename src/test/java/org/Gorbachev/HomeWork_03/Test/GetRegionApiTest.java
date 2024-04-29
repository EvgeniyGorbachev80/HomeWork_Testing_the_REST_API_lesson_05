package org.Gorbachev.HomeWork_03.Test;

import io.qameta.allure.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;


@Epic(value = "Тестирование API http://dataservice.accuweather.com")
@Feature(value = "Домашнее задание")
public class GetRegionApiTest extends AccuweatherAbstractTest {
    private final String API_KEY = "HBAoYTHBeloWennir9bjrNSNYgoGaCqz";
    private final String BASE_URL = "http://dataservice.accuweather.com";

    @Test
    @DisplayName("GetRegionApiTest")
    @Description("GET RegionInfo")
    @Link("")
    @Severity(SeverityLevel.NORMAL)
    @Owner("Evgeniy Gorbachev")
    @Story(value = "Тестирование метода getRegionInfo_shouldReturnValidData")
    void getRegionInfo_shouldReturnValidData() {
        // Given
        RestAssured.baseURI = BASE_URL;

        // When
        given()
                .queryParam("apikey", API_KEY)
                .accept(ContentType.JSON) // Установка формата JSON
                .when()
                .get("/locations/v1/regions")
                .then()
                .assertThat()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("LocalizedName", hasSize(greaterThan(0))) // Проверка наличия локализованных имен
                .body("EnglishName", hasSize(greaterThan(0))); // Проверка наличия английских имен
    }
}
