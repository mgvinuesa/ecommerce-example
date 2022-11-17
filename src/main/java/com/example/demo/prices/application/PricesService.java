package com.example.demo.prices.application;

import com.example.demo.prices.domain.repository.SearchPricesRepository;
import com.example.demo.prices.domain.usecase.search.SearchPrices;
import com.example.demo.prices.domain.usecase.search.SearchPricesResult;
import com.example.demo.prices.domain.usecase.search.SearchPricesUseCase;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PricesService implements SearchPricesUseCase {

	private SearchPricesRepository getPricesRepository;

	@Override
	public SearchPricesResult getPrices(SearchPrices command) {
		return new SearchPricesResult(this.getPricesRepository.getPricesByDateBrandAndProduct(
				command.getCurrentDate(), command.getBrandIdentification(), command.getProductIdentification()));
	}

}
