package com.example.demo.prices.infrastructure.persistence.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.example.demo.prices.domain.model.Price;
import com.example.demo.prices.infrastructure.persistence.entity.PriceEntity;

@Mapper
public interface PriceEntityMapper {

	List<Price> map(List<PriceEntity> listEntity);

	Price map(PriceEntity entity);

}
