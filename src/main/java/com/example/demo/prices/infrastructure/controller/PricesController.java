package com.example.demo.prices.infrastructure.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.prices.domain.usecase.search.SearchPrices;
import com.example.demo.prices.domain.usecase.search.SearchPricesResult;
import com.example.demo.prices.domain.usecase.search.SearchPricesUseCase;
import com.example.demo.prices.infrastructure.controller.model.PriceListResponse;
import com.example.demo.prices.infrastructure.controller.model.SearchPricesRequest;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "/prices")
@AllArgsConstructor
public class PricesController {

	private SearchPricesUseCase getPriceUseCase;

	@PostMapping(path = "/search")
	public PriceListResponse getPrices(@RequestBody SearchPricesRequest searchRequest) {
		SearchPrices command = SearchPrices.builder().brandIdentification(searchRequest.getBrandIdentification())
				.productIdentification(searchRequest.getProductIdentification())
				.currentDate(searchRequest.getCurrentDate()).build();
		SearchPricesResult result = getPriceUseCase.getPrices(command);
		return new PriceListResponse(result.getPriceList());
	}
}
