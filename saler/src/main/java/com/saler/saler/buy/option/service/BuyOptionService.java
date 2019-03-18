package com.saler.saler.buy.option.service;

import java.util.List;

import com.saler.saler.buy.option.entity.BuyOption;

/**
 * Deal service
 * @author Diego Andre Poli
 */
public interface BuyOptionService {

	/**
	 * Get deal by id
	 * @param id of deal
	 * @return deal
	 */
	BuyOption getById(Long id);
	
	/**
	 * Get all deals
	 * @return list of deals
	 */
	List<BuyOption> getAll();
	
	/**
	 * Add deal
	 * @param deal
	 * @return deal added
	 */
	BuyOption add(BuyOption deal);
	
	/**
	 * Remove deal
	 * @param id of deal
	 */
	void remove(Long id);
}
