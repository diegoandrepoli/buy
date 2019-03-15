package com.saler.saler.deal.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.saler.saler.deal.entity.DealType;
import com.saler.saler.deal.enums.DealTypeEnum;

/**
 * Deal types controller 
 * @author Diego Andre Poli <diegoandrepoli@gmail.com>
 */
@RestController
@RequestMapping("/type")
public class DealTypeController {
	
	/**
	 * Get all types
	 * @param http request
	 * @return enum types as list
	 */
	@CrossOrigin
	@RequestMapping(value="", method=RequestMethod.GET)
	public List<DealType> getAll(HttpServletRequest request){	
		return DealTypeEnum.objects();
	}

}
