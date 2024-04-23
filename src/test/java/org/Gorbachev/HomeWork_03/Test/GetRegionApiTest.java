package org.Gorbachev.HomeWork_03.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class GetRegionApiTest extends AccuweatherAbstractTest {

    private final String API_KEY = "HBAoYTHBeloWennir9bjrNSNYgoGaCqz";
    private final String BASE_URL = "http://dataservice.accuweather.com";

    @Test
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
