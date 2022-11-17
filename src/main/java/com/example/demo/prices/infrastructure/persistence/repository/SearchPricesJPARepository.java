package com.example.demo.prices.infrastructure.persistence.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.prices.infrastructure.persistence.entity.PriceEntity;

@Repository
public interface SearchPricesJPARepository extends CrudRepository<PriceEntity, Long> {

	List<PriceEntity> findByBrandIdentification(Long brandIdentification);

	List<PriceEntity> findByProductIdentification(Long productIdentification);

	List<PriceEntity> findByBrandIdentificationAndProductIdentificationAndStartDateBeforeAndEndDateAfter(
			Long brandIdentification, Long productIdentification, LocalDateTime startDate, LocalDateTime endDate);
}
