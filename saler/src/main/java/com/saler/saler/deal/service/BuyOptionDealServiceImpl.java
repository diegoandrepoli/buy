package com.saler.saler.deal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saler.saler.deal.entity.BuyOption;
import com.saler.saler.deal.repository.BuyOptionRepository;

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
}
