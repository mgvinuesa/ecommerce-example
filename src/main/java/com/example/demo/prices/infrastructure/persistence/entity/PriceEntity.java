package com.example.demo.prices.infrastructure.persistence.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Currency;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "PRICES")
public class PriceEntity {

	@Id
	@Column(name = "PRICE_LIST")
	private Long priceIdentification;

	@Column(name = "BRAND_ID")
	private Long brandIdentification;

	@Column(name = "PRODUCT_ID")
	private Long productIdentification;

	@Column(name = "START_DATE")
	private LocalDateTime startDate;

	@Column(name = "END_DATE")
	private LocalDateTime endDate;

	@Column(name = "PRIORITY")
	private Long priority;

	@Column(name = "PRICE")
	private BigDecimal price;

	@Column(name = "CURR")
	private Currency currency;

}
