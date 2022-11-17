package com.example.demo.prices.domain.usecase.search;

public interface SearchPricesUseCase {

	SearchPricesResult getPrices(SearchPrices command);
}
