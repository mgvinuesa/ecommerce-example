package com.example.demo.prices.infrastructure.controller.model;

import java.util.List;

import com.example.demo.prices.domain.model.Price;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PriceListResponse {

	private List<Price> priceList;
}
