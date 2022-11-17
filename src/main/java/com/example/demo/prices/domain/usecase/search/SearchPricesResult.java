package com.example.demo.prices.domain.usecase.search;

import java.util.List;

import com.example.demo.prices.domain.model.Price;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class SearchPricesResult {

	private List<Price> priceList;
}
