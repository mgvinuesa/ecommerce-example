package com.example.demo.prices.infrastructure.persistence.repository;

import java.time.LocalDateTime;
import java.util.List;

import com.example.demo.prices.domain.model.Price;
import com.example.demo.prices.domain.repository.SearchPricesRepository;
import com.example.demo.prices.infrastructure.persistence.mapper.PriceEntityMapper;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SearchPricesH2DatabaseRepository implements SearchPricesRepository {

	private SearchPricesJPARepository repository;

	private PriceEntityMapper mapper;

	@Override
	public List<Price> getPricesByDateBrandAndProduct(LocalDateTime date, Long brandIdentification,
			Long productIdentification) {
		return this.mapper
				.map(this.repository.findByBrandIdentificationAndProductIdentificationAndStartDateBeforeAndEndDateAfter(
						brandIdentification, productIdentification, date, date));
	}

}
