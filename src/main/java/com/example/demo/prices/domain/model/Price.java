package com.example.demo.prices.domain.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Currency;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Price {

	private Long priceIdentification;

	private Long brandIdentification;
	private Long productIdentification;

	private LocalDateTime startDate;
	private LocalDateTime endDate;
	private BigDecimal price;
	private Currency currency;

}
