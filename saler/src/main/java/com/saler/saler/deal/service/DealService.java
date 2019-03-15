package com.saler.saler.deal.service;

import java.util.List;

import com.saler.saler.deal.entity.Deal;

/**
 * Deal service
 * @author Diego Andre Poli
 */
public interface DealService {

	/**
	 * Get deal by id
	 * @param id of deal
	 * @return deal
	 */
	Deal getById(Long id);
	
	/**
	 * Get all deals
	 * @return list of deals
	 */
	List<Deal> getAll();
	
	/**
	 * Add deal
	 * @param deal
	 * @return deal added
	 */
	Deal add(Deal deal);
	
	/**
	 * Remove deal
	 * @param id of deal
	 */
	void remove(Long id);
}
