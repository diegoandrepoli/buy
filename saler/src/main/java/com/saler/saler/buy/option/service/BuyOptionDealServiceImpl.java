package com.saler.saler.buy.option.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saler.saler.buy.option.entity.BuyOption;
import com.saler.saler.buy.option.repository.BuyOptionRepository;

/**
 * Deal service implementation
 * @author Diego Andre Poli <diegoandrepoli@gmail.com>
 */
@Service("buyOptionService")
public class BuyOptionDealServiceImpl implements BuyOptionService {

	/**
	 * Repository of deal
	 */
	@Autowired
	BuyOptionRepository buyOptionRepository;
	
	/**
	 * Get deal by id
	 * @param id of deal
	 * @return deal
	 */
	@Override
	public BuyOption getById(Long id) {
		return buyOptionRepository.findById(id).get();
	}

	/**
	 * Get all deals
	 * @return deal list
	 */
	@Override
	public List<BuyOption> getAll() {		
		return buyOptionRepository.findAll();
	}
	
	/**
	 * Add deal
	 * @param deal
	 * @return deal saved
	 */
	@Override
	public BuyOption add(BuyOption deal) {
		return buyOptionRepository.save(deal);
	}

	/**
	 * Remove deal
	 * @param id of deal
	 */
	@Override
	public void remove(Long id) {
		buyOptionRepository.deleteById(id);
	}
	
	/**
	 * Decrement cupon
	 * @param id as buy option
	 */
	@Override
	public void decrementCupon(Long id) {
		BuyOption option = getById(id);
		option.setQuantityCupom(option.getQuantityCupom()-1);
		add(option);
	}
	
}
