package com.saler.saler.deal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saler.saler.buy.option.entity.BuyOption;
import com.saler.saler.deal.entity.Deal;
import com.saler.saler.deal.repository.DealRepository;

/**
 * Deal service implementation
 * @author Diego Andre Poli <diegoandrepoli@gmail.com>
 */
@Service("dealService")
public class DealServiceImpl implements DealService {

	/**
	 * Repository of deal
	 */
	@Autowired
	DealRepository dealRepository;
	
	/**
	 * Get deal by id
	 * @param id of deal
	 * @return deal
	 */
	@Override
	public Deal getById(Long id) {
		return dealRepository.findById(id).get();	
	}	
	
	/**
	 * Get id by url
	 * @param url
	 * @return id
	 */
	@Override
	public Long getIdByUrl(String url) {
		return dealRepository.findIdUrl(url);		
	}

	/**
	 * Get all deals
	 * @return deal list
	 */
	@Override
	public List<Deal> getAll() {
		return dealRepository.findAll();
	}
	
	/**
	 * Add deal
	 * @param deal
	 * @return deal saved
	 */
	@Override
	public Deal add(Deal deal) {
		return dealRepository.save(deal);
	}

	/**
	 * Remove deal
	 * @param id of deal
	 */
	@Override
	public void remove(Long id) {
		dealRepository.deleteById(id);
	}
	
	/**
	 * Add buy option
	 * @param deal id
	 * @param buy option
	 * @return deal
	 */
	@Override
	public Deal addBuyOption(Long id, BuyOption buyOption) {
		Deal deal = getById(id);
		deal.addBuyOption(buyOption);
		return dealRepository.save(deal);		
	}
	
	/**
	 * Decrement cupon
	 * @param id
	 */
	@Override
	public void decrementCupon(Long id) {
		Deal deal = getById(id);		
		deal.setTotalSold(deal.getTotalSold() + 1);
		add(deal);	
	}
	
	/**
	 * Get by url
	 * @param url as string
	 * @return deal
	 */
	@Override
	public Deal getByUrl(String url) {
		return getById(getIdByUrl(url));		
	}
	
	/**
	 * Save or update deal
	 * @param deal
	 * @return deal
	 */
	@Override
	public Deal saveOrUpdate(Deal deal) {
		//is update (TODO: test on not set buy options)
		if(deal.getId() != null) {			
			deal.setBuyOptions(getById(deal.getId()).getBuyOptions());
		}
		
		//save deal
		return add(deal);	
	}
	
}
