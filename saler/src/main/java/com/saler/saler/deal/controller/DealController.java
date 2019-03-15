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

import com.saler.saler.deal.entity.Deal;
import com.saler.saler.deal.service.DealService;

/**
 * Deal api controller
 * @author Diego Andre Poli <diegoandrepoli@gmail.com>
 */
@RestController
@RequestMapping("/deal")
public class DealController {

	/**
	 * Deal service
	 */
	@Autowired
	private DealService dealService;
	
	/**
	 * Add deal service
	 * @param deal object
	 * @return deal object
	 */
	@CrossOrigin
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public Deal addProduct(@RequestBody Deal deal) {		
		return dealService.add(deal);
	}
	
	/**
	 * Get all deal
	 * @param request
	 * @return
	 */
	@CrossOrigin
	@RequestMapping(value="", method=RequestMethod.GET)
	public List<Deal> getAll(HttpServletRequest request){	
		return dealService.getAll();
	}
	
	/**
	 * Get deal by id
	 * @param id of deal
	 * @return deal
	 */
	@CrossOrigin
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public Deal getDeal(@PathVariable("id") Long id) {
		return dealService.getById(id);
	}
	
	/**
	 * Delete deal
	 * @param id of deal
	 */
	@CrossOrigin
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public void deleteDeal(@PathVariable("id") Long id) {
		dealService.remove(id);		
	}
}
