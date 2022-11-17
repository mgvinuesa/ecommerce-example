package com.example.demo.prices.domain.usecase.search;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class SearchPrices {

	private Long productIdentification;
	private Long brandIdentification;
	private LocalDateTime currentDate;
}
