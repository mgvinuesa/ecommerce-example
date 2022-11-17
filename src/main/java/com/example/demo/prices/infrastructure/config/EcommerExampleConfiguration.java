package com.example.demo.prices.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.prices.application.PricesService;
import com.example.demo.prices.domain.repository.SearchPricesRepository;
import com.example.demo.prices.domain.usecase.search.SearchPricesUseCase;
import com.example.demo.prices.infrastructure.persistence.mapper.PriceEntityMapper;
import com.example.demo.prices.infrastructure.persistence.repository.SearchPricesH2DatabaseRepository;
import com.example.demo.prices.infrastructure.persistence.repository.SearchPricesJPARepository;

@Configuration
public class EcommerExampleConfiguration {

	@Bean
	public SearchPricesUseCase pricesService(SearchPricesRepository getPricesRepository) {
		return new PricesService(getPricesRepository);
	}

	@Bean
	public SearchPricesRepository pricesRepository(SearchPricesJPARepository jpaRepository, PriceEntityMapper priceMapper) {
		return new SearchPricesH2DatabaseRepository(jpaRepository, priceMapper);
	}
}
