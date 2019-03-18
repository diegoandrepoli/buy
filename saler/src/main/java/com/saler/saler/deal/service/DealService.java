package com.saler.saler.deal.service;

import java.util.List;

import com.saler.saler.buy.option.entity.BuyOption;
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
	
	/**
	 * Get id by url
	 * @param deal url
	 * @return deal id
	 */
	Long getIdByUrl(String url);
	
	/**
	 * Add buy option 
	 * @param deal id 
	 * @param buy option
	 * @return deal
	 */
	Deal addBuyOption(Long id, BuyOption buyOption);
	
	/**
	 * Decrement cupon
	 * @param deal id
	 */
	void decrementCupon(Long id);
	
	/**
	 * Get by url
	 * @param deal url
	 * @return deal
	 */
	Deal getByUrl(String url);
	
	/**
	 * Save or update deal
	 * @param deal
	 * @return deal
	 */
	Deal saveOrUpdate(Deal deal);
}
