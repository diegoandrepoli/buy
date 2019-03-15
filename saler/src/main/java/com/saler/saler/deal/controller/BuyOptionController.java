package com.saler.saler.deal.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.saler.saler.deal.entity.BuyOption;
import com.saler.saler.deal.service.BuyOptionService;

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
	
	/**
	 * Add deal service
	 * @param deal object
	 * @return deal object
	 */
	@CrossOrigin
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public BuyOption addProduct(@RequestBody BuyOption deal) {		
		return buyOptionService.add(deal);
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
