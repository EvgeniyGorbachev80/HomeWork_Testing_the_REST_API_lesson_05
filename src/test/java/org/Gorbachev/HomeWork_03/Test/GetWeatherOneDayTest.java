package org.Gorbachev.HomeWork_03.Test;

import io.qameta.allure.*;
import org.Gorbachev.HomeWork_03.accuweather.weather.DailyForecast;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.Gorbachev.HomeWork_03.accuweather.weather.Weather;

import java.util.List;

import static io.restassured.RestAssured.given;

@Epic(value = "Тестирование API http://dataservice.accuweather.com")
@Feature(value = "Домашнее задание")
public class GetWeatherOneDayTest extends AccuweatherAbstractTest {
    @Test
    @DisplayName("GetWeatherOneDayTest")
    @Description("GET WeatherOneDay")
    @Link("")
    @Severity(SeverityLevel.NORMAL)
    @Owner("Evgeniy Gorbachev")
    @Story(value = "Тестирование метода getWeatherOneDay_shouldReturn")
    void getWeatherOneDay_shouldReturn() {

        Weather response = given()
                .queryParam("apikey", getApiKey())
                .when()
                .get(getBaseUrl()+"/forecasts/v1/daily/1day/290396")
                .then()
                .statusCode(200)
                .time(Matchers.lessThan(2000l))
                .extract()
                .response()
                .body().as(Weather.class);

        Assertions.assertEquals(1,response.getDailyForecasts().size());
        Assertions.assertNotNull(response.getHeadline());
    }

    @Test
    @DisplayName("GetWeatherOneDayTest")
    @Description("GET DailyForecastsList")
    @Link("")
    @Severity(SeverityLevel.NORMAL)
    @Owner("Evgeniy Gorbachev")
    @Story(value = "Тестирование метода getDailyForecastsList")
    void getDailyForecastsList() {

        List<DailyForecast> response = given()
                .queryParam("apikey", getApiKey())
                .when()
                .get(getBaseUrl()+"/forecasts/v1/daily/1day/290396")
                .then()
                .statusCode(200)
                .time(Matchers.lessThan(2000l))
                .extract()
                .response()
                .body().jsonPath().getList("DailyForecasts", DailyForecast.class);

        Assertions.assertEquals(1,response.size());
    }

    @Test
    @DisplayName("GetWeatherOneDayTest")
    @Description("GET String")
    @Link("")
    @Severity(SeverityLevel.NORMAL)
    @Owner("Evgeniy Gorbachev")
    @Story(value = "Тестирование метода getString")
    void getString() {
        String response = given()
                .queryParam("apikey", getApiKey())
                .when()
                .get(getBaseUrl()+"/forecasts/v1/daily/1day/290396")
                .then()
                .statusCode(200)
                .time(Matchers.lessThan(2000l))
                .extract().asString();

        Assertions.assertTrue(response.contains("Headline"));
        Assertions.assertTrue(response.contains("DailyForecasts"));
    }
}
