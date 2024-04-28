package org.Gorbachev.HomeWork_03.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class GetElevationApiTest extends AccuweatherAbstractTest {
    private final String API_KEY = "HBAoYTHBeloWennir9bjrNSNYgoGaCqz";
    private final String BASE_URL = "http://dataservice.accuweather.com";

    @Test
    void getElevationInfo_shouldReturnValidData() {
        // Given
        RestAssured.baseURI = BASE_URL;

        // When
        given()
                .queryParam("apikey", API_KEY)
                .queryParam("q", "New York") // Пример местоположения
                .accept(ContentType.JSON) // Установка формата JSON
                .when()
                .get("/locations/v1/cities/geoposition/search")
                .then()
                .assertThat()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("Elevation.Metric.Value", notNullValue()) // Проверка метрического значения высоты
                .body("Elevation.Imperial.Value", notNullValue()); // Проверка имперских значений высоты
    }
}
