package com.oandujar.sisu;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PocSisuTest {

    @LocalServerPort
    private int port;

    private final String BASE_URL = "http://localhost";

    @BeforeEach
    public void setUp() {
        RestAssured.baseURI = BASE_URL.concat(":").concat(String.valueOf(port));
    }

    /**
     * Test 1: petición a las 10:00 del día 14 del producto 35455 para la brand 1 (CADENA1)
     */

    @Test
    public void Test1() {
        String brandId = "1";
        String productId = "35455";
        String offsetDateTime = "2020-06-14T10:00:00+02:00";

        // Solo lo debe de cumplir el price_list 1
        RestAssured.given()
                .contentType(ContentType.JSON)
                .param("date", offsetDateTime)
                .when()
                .get("/price/brand/{brandId}/product/{productId}", brandId, productId)
                .then().log().ifStatusCodeIsEqualTo(200)
                .statusCode(200)
                .body("fee", equalTo(1))
                .body("price", equalTo("35,50"));
    }

    /**
     * Test 2: petición a las 16:00 del día 14 del producto 35455 para la brand 1 (CADENA1)
     */
    @Test
    public void Test2() {
        String brandId = "1";
        String productId = "35455";
        String offsetDateTime = "2020-06-14T16:00:00+02:00";

        // Lo deben cumplir el price_list 1 y 2, desempata el 2 por la prioridad
        RestAssured.given()
                .contentType(ContentType.JSON)
                .param("date", offsetDateTime)
                .when()
                .get("/price/brand/{brandId}/product/{productId}", brandId, productId)
                .then().log().ifStatusCodeIsEqualTo(200)
                .statusCode(200)
                .body("fee", equalTo(2))
                .body("price", equalTo("25,45"));
    }

    /**
     * Test 3: petición a las 21:00 del día 14 del producto 35455 para la brand 1 (CADENA1)
     */
    @Test
    public void Test3() {
        String brandId = "1";
        String productId = "35455";
        String offsetDateTime = "2020-06-14T21:00:00+02:00";

        // Solo lo debe de cumplir el price_list 1
        RestAssured.given()
                .contentType(ContentType.JSON)
                .param("date", offsetDateTime)
                .when()
                .get("/price/brand/{brandId}/product/{productId}", brandId, productId)
                .then().log().ifStatusCodeIsEqualTo(200)
                .statusCode(200)
                .body("fee", equalTo(1))
                .body("price", equalTo("35,50"));
    }

    /**
     *
     * Test 4: petición a las 10:00 del día 15 del producto 35455 para la brand 1 (CADENA1)
     */
    @Test
    public void Test4() {
        String brandId = "1";
        String productId = "35455";
        String offsetDateTime = "2020-06-15T10:00:00+02:00";

        // Lo deben cumplir el price_list 1 y 3, desempata el 3 por la prioridad
        RestAssured.given()
                .contentType(ContentType.JSON)
                .param("date", offsetDateTime)
                .when()
                .get("/price/brand/{brandId}/product/{productId}", brandId, productId)
                .then().log().ifStatusCodeIsEqualTo(200)
                .statusCode(200)
                .body("fee", equalTo(3))
                .body("price", equalTo("30,50"));
    }

    /**
     * Test 5: petición a las 21:00 del día 16 del producto 35455 para la brand 1 (CADENA1)
     */
    @Test
    public void Test5() {
        String brandId = "1";
        String productId = "35455";
        String offsetDateTime = "2020-06-16T21:00:00+02:00";

        // Lo deben cumplir el price_list 1 y 4, desempata el 4 por la prioridad
        RestAssured.given()
                .contentType(ContentType.JSON)
                .param("date", offsetDateTime)
                .when()
                .get("/price/brand/{brandId}/product/{productId}", brandId, productId)
                .then().log().ifStatusCodeIsEqualTo(200)
                .statusCode(200)
                .body("fee", equalTo(4))
                .body("price", equalTo("38,95"));;
    }

}
