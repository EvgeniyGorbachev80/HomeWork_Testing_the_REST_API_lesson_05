package org.Gorbachev.HomeWork_03.Test;

import io.qameta.allure.*;
import io.restassured.http.Method;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

@Epic(value = "Тестирование API http://dataservice.accuweather.com")
@Feature(value = "Домашнее задание")
public class GetWeatherFifteenDayTest extends AccuweatherAbstractTest {
    @Test
    @DisplayName("GetWeatherFifteenDayTest")
    @Description("GET fifteen_day_return_401")
    @Link("")
    @Severity(SeverityLevel.NORMAL)
    @Owner("Evgeniy Gorbachev")
    @Story(value = "Тестирование метода get_fifteen_day_return_401")
    void get_fifteen_day_return_401() {

        given()
                .queryParam("apikey", getApiKey())
                .pathParam("version", "v1")
                .pathParam("location", 290396)
                .when()
                .request(Method.GET,getBaseUrl()+"/forecasts/{version}/daily/15day/{location}")
                .then()
                .statusCode(401);
    }
}
