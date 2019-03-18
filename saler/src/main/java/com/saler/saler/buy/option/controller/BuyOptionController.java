package com.saler.saler.buy.option.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.saler.saler.buy.option.entity.BuyOption;
import com.saler.saler.buy.option.service.BuyOptionService;
import com.saler.saler.deal.entity.Deal;
import com.saler.saler.deal.service.DealService;

/**
 * Deal api controller
 * @author Diego Andre Poli <diegoandrepoli@gmail.com>
 */
@RestController
@RequestMapping("/buy-option")
public class BuyOptionController {

	/**
	 * Deal service
	 */
	@Autowired
	private BuyOptionService buyOptionService;
	
	@Autowired
	private DealService dealService;
	
	/**
	 * Add deal service
	 * @param deal object
	 * @return deal object
	 */
	@CrossOrigin
	@RequestMapping(value="/add/deal/{id}", method=RequestMethod.POST)
	public Deal addProduct(@PathVariable("id") Long id, @RequestBody BuyOption buyOption) {	
		Deal deal = dealService.getById(id);
		deal.addBuyOption(buyOption);
		dealService.add(deal);
		return deal;
	}
	
	@CrossOrigin
	@RequestMapping(value="/update", method=RequestMethod.PUT)
	public BuyOption update(@RequestBody BuyOption buyOption) {
		return buyOptionService.add(buyOption);		
	}
	
	/**
	 * Get all deal
	 * @param request
	 * @return
	 */
	@CrossOrigin
	@RequestMapping(value="", method=RequestMethod.GET)
	public List<BuyOption> getAll(HttpServletRequest request){	
		return buyOptionService.getAll();
	}
	
	/**
	 * Get deal by id
	 * @param id of deal
	 * @return deal
	 */
	@CrossOrigin
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public BuyOption getDeal(@PathVariable("id") Long id) {
		return buyOptionService.getById(id);
	}
	
	@CrossOrigin
	@RequestMapping(value="/decrement/deal/{id}", method=RequestMethod.PUT)
	public void decrementQuantity(@PathVariable("id") Long id) {
		BuyOption buyOption = buyOptionService.getById(id);
		buyOption.setQuantityCupom(buyOption.getQuantityCupom()-1);
		buyOptionService.add(buyOption);
	}
	
	/**
	 * Delete deal
	 * @param id of deal
	 */
	@CrossOrigin
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public void deleteDeal(@PathVariable("id") Long id) {
		buyOptionService.remove(id);		
	}
}
