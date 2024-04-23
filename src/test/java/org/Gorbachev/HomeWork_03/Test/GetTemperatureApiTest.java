package org.Gorbachev.HomeWork_03.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;


public class GetTemperatureApiTest extends AccuweatherAbstractTest {
    private final String API_KEY = "HBAoYTHBeloWennir9bjrNSNYgoGaCqz";
    private final String BASE_URL = "http://dataservice.accuweather.com";

    @Test
    void getTemperatureInfo_shouldReturnValidData() {

            // Given
            RestAssured.baseURI = BASE_URL;

            // When
            given()
                    .queryParam("apikey", API_KEY)
                    .accept(ContentType.JSON) // Установка формата JSON
                    .when()
                    .get("/forecasts/v1/daily/1day/27612")
                    .then()
                    .assertThat()
                    .statusCode(200)
                    .contentType(ContentType.JSON)
                    .body("DailyForecasts.Temperature.Minimum.Value", notNullValue()) // Проверка минимальной температуры
                    .body("DailyForecasts.Temperature.Maximum.Value", notNullValue()); // Проверка максимальной температуры
        }
    }



