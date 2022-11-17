package com.example.demo.prices.domain.repository;

import java.time.LocalDateTime;
import java.util.List;

import com.example.demo.prices.domain.model.Price;

public interface SearchPricesRepository {

	List<Price> getPricesByDateBrandAndProduct(LocalDateTime date, Long brandIdentification,
			Long productIdentification);
}
