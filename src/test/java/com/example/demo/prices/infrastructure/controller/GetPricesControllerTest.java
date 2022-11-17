package com.example.demo.prices.infrastructure.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.MockMvc;

import com.example.demo.prices.domain.model.Price;
import com.example.demo.prices.infrastructure.controller.model.PriceListResponse;
import com.example.demo.prices.infrastructure.controller.model.SearchPricesRequest;

import io.restassured.http.ContentType;
import io.restassured.module.mockmvc.RestAssuredMockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class GetPricesControllerTest {

	private static final long ZARA_BRAND = 1l;
	private static final long DEFAULT_PRODUCT_ID = 35455l;
	private static final LocalDateTime TEST_CONDITION_ONE = LocalDateTime.of(2020, 06, 14, 10, 0, 0);
	@Autowired
	private MockMvc mockMvc;

	@BeforeEach
	void prepareMockMvc() {
		RestAssuredMockMvc.mockMvc(mockMvc);
	}

	@Test
	@DisplayName("petición a las 10:00 del día 14 del producto 35455 para la brand 1 (ZARA)")
	void givenTheConditionOneReturnOnlyOneElementFromDatabase() {
		PriceListResponse response = RestAssuredMockMvc.given()
				.body(new SearchPricesRequest(DEFAULT_PRODUCT_ID, ZARA_BRAND, TEST_CONDITION_ONE))
				.contentType(ContentType.JSON).when().post("/prices/search").then().statusCode(HttpStatus.OK.value())
				.extract().as(PriceListResponse.class);

		Assertions.assertAll(() -> {
			assertThat(theResponseHasThisSize(response, 1));
			assertThat(theEntityHasThisInformation(response.getPriceList().get(0), 1L, 1L,
					LocalDateTime.of(2020, 06, 14, 0, 0, 0), LocalDateTime.of(2020, 12, 31, 23, 59, 59),
					BigDecimal.valueOf(35.50)));
		});

	}

	@Test
	@DisplayName("petición a las 16:00 del día 14 del producto 35455   para la brand 1 (ZARA)")
	void givenTheAboveCondition_ReturnOnlyOneElementFromDatabase2() {
		LocalDateTime dateToSearch = LocalDateTime.of(2020, 06, 14, 16, 0, 0);
		PriceListResponse response = RestAssuredMockMvc.given()
				.body(new SearchPricesRequest(DEFAULT_PRODUCT_ID, ZARA_BRAND, dateToSearch))
				.contentType(ContentType.JSON).when().post("/prices/search").then().statusCode(HttpStatus.OK.value())
				.extract().as(PriceListResponse.class);

		Assertions.assertAll(() -> {
			assertThat(theResponseHasThisSize(response, 2));
			assertThat(assertThat(theEntityHasThisInformation(response.getPriceList().get(0), 1L, 1L,
					LocalDateTime.of(2020, 06, 14, 0, 0, 0), LocalDateTime.of(2020, 12, 31, 23, 59, 59),
					BigDecimal.valueOf(35.50))));
			assertThat(assertThat(theEntityHasThisInformation(response.getPriceList().get(0), 2L, 1L,
					LocalDateTime.of(2020, 06, 14, 15, 0, 0), LocalDateTime.of(2020, 06, 14, 18, 30, 00),
					BigDecimal.valueOf(25.45))));
		});

	}

	@Test
	@DisplayName("petición a las 21:00 del día 14 del producto 35455   para la brand 1 (ZARA)")
	void givenTheAboveCondition_ReturnOnlyOneElementFromDatabase3() {
		LocalDateTime dateToSearch = LocalDateTime.of(2020, 06, 14, 21, 0, 0);
		PriceListResponse response = RestAssuredMockMvc.given()
				.body(new SearchPricesRequest(DEFAULT_PRODUCT_ID, ZARA_BRAND, dateToSearch))
				.contentType(ContentType.JSON).when().post("/prices/search").then().statusCode(HttpStatus.OK.value())
				.extract().as(PriceListResponse.class);

		Assertions.assertAll(() -> {
			assertThat(theResponseHasThisSize(response, 1));
			assertThat(assertThat(theEntityHasThisInformation(response.getPriceList().get(0), 1L, 1L,
					LocalDateTime.of(2020, 06, 14, 0, 0, 0), LocalDateTime.of(2020, 12, 31, 23, 59, 59),
					BigDecimal.valueOf(35.50))));
		});

	}

	@Test
	@DisplayName("petición a las 10:00 del día 15 del producto 35455   para la brand 1 (ZARA)")
	void givenTheAboveCondition_ReturnOnlyOneElementFromDatabase4() {
		LocalDateTime dateToSearch = LocalDateTime.of(2020, 06, 15, 10, 0, 0);
		PriceListResponse response = RestAssuredMockMvc.given()
				.body(new SearchPricesRequest(DEFAULT_PRODUCT_ID, ZARA_BRAND, dateToSearch))
				.contentType(ContentType.JSON).when().post("/prices/search").then().statusCode(HttpStatus.OK.value())
				.extract().as(PriceListResponse.class);

		Assertions.assertAll(() -> {
			assertThat(theResponseHasThisSize(response, 2));
			assertThat(assertThat(theEntityHasThisInformation(response.getPriceList().get(0), 1L, 1L,
					LocalDateTime.of(2020, 06, 14, 0, 0, 0), LocalDateTime.of(2020, 12, 31, 23, 59, 59),
					BigDecimal.valueOf(35.50))));
			assertThat(assertThat(assertThat(theEntityHasThisInformation(response.getPriceList().get(0), 3L, 1L,
					LocalDateTime.of(2020, 06, 15, 0, 0, 0), LocalDateTime.of(2020, 06, 15, 11, 00, 00),
					BigDecimal.valueOf(30.50)))));
		});

	}

	@Test
	@DisplayName("petición a las 21:00 del día 16 del producto 35455   para la brand 1 (ZARA)")
	void givenTheAboveCondition_ReturnOnlyOneElementFromDatabase5() {
		LocalDateTime dateToSearch = LocalDateTime.of(2020, 06, 16, 21, 0, 0);
		PriceListResponse response = RestAssuredMockMvc.given()
				.body(new SearchPricesRequest(DEFAULT_PRODUCT_ID, ZARA_BRAND, dateToSearch))
				.contentType(ContentType.JSON).when().post("/prices/search").then().statusCode(HttpStatus.OK.value())
				.extract().as(PriceListResponse.class);

		Assertions.assertAll(() -> {
			assertThat(theResponseHasThisSize(response, 2));
			assertThat(assertThat(theEntityHasThisInformation(response.getPriceList().get(0), 1L, 1L,
					LocalDateTime.of(2020, 06, 14, 0, 0, 0), LocalDateTime.of(2020, 12, 31, 23, 59, 59),
					BigDecimal.valueOf(35.50))));
			assertThat(assertThat(assertThat(theEntityHasThisInformation(response.getPriceList().get(0), 4L, 1L,
					LocalDateTime.of(2020, 06, 15, 16, 0, 0), LocalDateTime.of(2020, 12, 31, 23, 59, 59),
					BigDecimal.valueOf(38.95)))));
		});

	}

	private boolean theEntityHasThisInformation(Price price, Long expectedId, Long expectedBrandId,
			LocalDateTime expectedStartDate, LocalDateTime expectedEndDate, BigDecimal expectedPrice) {
		return price.getPriceIdentification() == expectedId && price.getBrandIdentification() == expectedBrandId
				&& price.getStartDate().isEqual(expectedStartDate) && price.getEndDate().isEqual(expectedEndDate)
				&& price.getPrice().equals(expectedPrice);
	}

	private boolean theResponseHasThisSize(PriceListResponse response, long size) {
		return response.getPriceList() != null && response.getPriceList().size() == size;
	}

}
