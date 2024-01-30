package com.oandujar;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import java.util.stream.Stream;

import static org.hamcrest.Matchers.equalTo;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class IntegrationTest {

    @LocalServerPort
    private int port;

    private final String BASE_URL = "http://localhost";

    @BeforeEach
    public void setUp() {
        RestAssured.baseURI = BASE_URL.concat(":").concat(String.valueOf(port));
    }

    private static Stream<Arguments> provideParams() {
        return Stream.of(
                /**
                 * Test 1: petición a las 10:00 del día 14 del producto 35455 para la brand 1 (CADENA1)
                 * Lo debe cumplir el price_list 1
                 */
                Arguments.of(35455L, 1L, "2020-06-14T10:00:00+02:00", 1, "35,50"),
                /**
                 * Test 2: petición a las 16:00 del día 14 del producto 35455 para la brand 1 (CADENA1)
                 * Lo deben cumplir el price_list 1 y 2, desempata el 2 por la prioridad
                 */
                Arguments.of(35455L, 1L, "2020-06-14T16:00:00+02:00", 2, "25,45"),
                /**
                 * Test 3: petición a las 21:00 del día 14 del producto 35455 para la brand 1 (CADENA1)
                 * Solo lo debe de cumplir el price_list 1
                 */
                Arguments.of(35455L, 1L, "2020-06-14T21:00:00+02:00", 1, "35,50"),
                /**
                 * Test 4: petición a las 10:00 del día 15 del producto 35455 para la brand 1 (CADENA1)
                 * Lo deben cumplir el price_list 1 y 3, desempata el 3 por la prioridad
                 */
                Arguments.of(35455L, 1L, "2020-06-15T10:00:00+02:00", 3, "30,50"),
                /**
                 * Test 5: petición a las 21:00 del día 16 del producto 35455 para la brand 1 (CADENA1)
                 * Lo deben cumplir el price_list 1 y 4, desempata el 4 por la prioridad
                 */
                Arguments.of(35455L, 1L, "2020-06-16T21:00:00+02:00", 4, "38,95")
        );
    }

    @ParameterizedTest(name = "Test: producto {1} de la marca {0} a las {2} tiene la tarifa {3} con un precio de {4} ")
    @MethodSource("provideParams")
    public void readmeTestCase(Long productId, Long brandId, String applicationDate, Integer feeExpected, String priceExpected) {
        RestAssured.given()
                .contentType(ContentType.JSON)
                .param("applicationDate", applicationDate)
                .when()
                .get("/product/{productId}/brand/{brandId}/fee", productId, brandId)
                .then().log().ifStatusCodeIsEqualTo(200)
                .statusCode(200)
                .body("fee", equalTo(feeExpected))
                .body("price", equalTo(priceExpected));
    }

}
