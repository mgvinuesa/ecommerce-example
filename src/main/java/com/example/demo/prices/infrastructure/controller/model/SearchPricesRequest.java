package com.example.demo.prices.infrastructure.controller.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

//Don't use lombok due to bad integration with Jackson & JsonFormat annotation
public class SearchPricesRequest {

	private Long productIdentification;
	private Long brandIdentification;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime currentDate;

	public SearchPricesRequest() {
	}

	public SearchPricesRequest(Long productIdentification, Long brandIdentification, LocalDateTime currentDate) {
		super();
		this.productIdentification = productIdentification;
		this.brandIdentification = brandIdentification;
		this.currentDate = currentDate;
	}

	public Long getProductIdentification() {
		return productIdentification;
	}

	public void setProductIdentification(Long productIdentification) {
		this.productIdentification = productIdentification;
	}

	public Long getBrandIdentification() {
		return brandIdentification;
	}

	public void setBrandIdentification(Long brandIdentification) {
		this.brandIdentification = brandIdentification;
	}

	public LocalDateTime getCurrentDate() {
		return currentDate;
	}

	public void setCurrentDate(LocalDateTime currentDate) {
		this.currentDate = currentDate;
	}

}
