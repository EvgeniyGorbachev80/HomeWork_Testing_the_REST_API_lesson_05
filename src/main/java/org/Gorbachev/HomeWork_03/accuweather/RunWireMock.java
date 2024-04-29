package org.Gorbachev.HomeWork_03.accuweather;

import com.github.tomakehurst.wiremock.WireMockServer;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

public class RunWireMock {

    public static void main(String[] args) {
        WireMockServer wireMockServer = new WireMockServer();
        wireMockServer.start();
        configureFor("localhost", 8080);

        stubFor(get(urlEqualTo("/test/urlequal")).willReturn(aResponse().withBody("Welcome to test!")));

        //бесконечный цикл
        while (true) {

        }
    }
}
