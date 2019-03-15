package com.saler.saler.deal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
