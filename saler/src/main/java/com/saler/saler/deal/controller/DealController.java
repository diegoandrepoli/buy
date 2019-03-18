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

import com.saler.saler.buy.option.entity.BuyOption;
import com.saler.saler.buy.option.service.BuyOptionService;
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
	

		@Autowired
		private BuyOptionService buyOptionService;
		

	/**
	 * Add deal service
	 * @param deal object
	 * @return deal object
	 */
	@CrossOrigin
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public Deal addProduct(@RequestBody Deal deal) {
		if(deal.getId() != null) {
			Deal byId = dealService.getById(deal.getId());			
			deal.setBuyOptions(byId.getBuyOptions());
		}
		dealService.add(deal);
		return dealService.add(deal);
	}
	
	
	@CrossOrigin
	@RequestMapping(value="/merge", method=RequestMethod.POST)
	public Deal addBuyOption(@RequestBody Deal deal) {		
		Deal dealing = dealService.getById(deal.getId());
		dealing.setMergeBuyOptions(deal.getBuyOptions());
		return dealService.add(dealing);		
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
	
	@CrossOrigin
	@RequestMapping(value="/url/{url}", method=RequestMethod.GET)
	public Deal getDealByUrl(@PathVariable("url") String url) {
		Long id = dealService.getIdByUrl(url);
		Deal byId = dealService.getById(id);
		
//		Date publishDate = byId.getPublishDate();
//		Date endDate = byId.getEndDate();
//		
//		if(publishDate.after(new Date()) || endDate.after(new Date())) {
//			return new  Deal
//		}
		
		return byId;
	}
	
	
	@CrossOrigin
	@RequestMapping(value="/{dealId}/decrement/buy-option/{buyOptionId}", method=RequestMethod.PUT)
	public void decrementQuantity(@PathVariable("dealId") Long dealId, @PathVariable("buyOptionId") Long buyOptionId) {
		BuyOption buyOption = buyOptionService.getById(buyOptionId);
		buyOption.setQuantityCupom(buyOption.getQuantityCupom()-1);
		buyOptionService.add(buyOption);
		
		Deal byId = dealService.getById(dealId);
		Long totalSold = byId.getTotalSold();
		byId.setTotalSold(totalSold + 1);
		dealService.add(byId);	
	}
}
