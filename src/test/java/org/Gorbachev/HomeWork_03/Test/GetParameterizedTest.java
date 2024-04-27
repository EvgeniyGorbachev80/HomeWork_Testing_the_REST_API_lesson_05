package org.Gorbachev.HomeWork_03.Test;

import io.qameta.allure.*;
import io.restassured.http.Method;
import jdk.jfr.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static io.restassured.RestAssured.given;

@Epic(value = "Тестирование API http://dataservice.accuweather.com")
@Feature(value = "Домашнее задание")
public class GetParameterizedTest extends AccuweatherAbstractTest {

    @ParameterizedTest
    @DisplayName("GetParameterizedTest")
    @Description("GET ten_day_return_401")
    @Link("")
    @Severity(SeverityLevel.NORMAL)
    @Owner("Evgeniy Gorbachev")
    @Story(value = "Тестирование метода get_ten_day_return_401")
    @ValueSource(ints = {25, 50, 100})
    void get_ten_day_return_401(int location) {

        given()
                .queryParam("apikey", getApiKey())
                .pathParam("version", "v1")
                .pathParam("location", location)
                .when()
                .request(Method.GET,getBaseUrl()+"/forecasts/{version}/daily/10day/{location}")
                .then()
                .statusCode(401);

    }
}
