package org.Gorbachev.HomeWork_03.Test;

import io.qameta.allure.*;
import org.Gorbachev.HomeWork_03.accuweather.location.Location;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

@Epic(value = "Тестирование API http://dataservice.accuweather.com")
@Feature(value = "Домашнее задание")
public class GetLocationTest extends AccuweatherAbstractTest {
    @Test
    @DisplayName("GetLocationTest")
    @Description("GET Location_search_returnGomel")
    @Link("")
    @Severity(SeverityLevel.NORMAL)
    @Owner("Evgeniy Gorbachev")
    @Story(value = "Тестирование метода Location")
    void getLocation_search_returnGomel() {

        List<Location> response = given()
                .queryParam("apikey", getApiKey())
                .queryParam("q", "Gomel")
                .when()
                .get(getBaseUrl()+"/locations/v1/cities/search")
                .then()
                .statusCode(200)
                .time(Matchers.lessThan(2000l))
                .extract()
                .body().jsonPath().getList(".", Location.class);

        Assertions.assertEquals(1,response.size());
        Assertions.assertEquals("Gomel", response.get(0).getEnglishName());
    }
}
