package com.saler.saler.pages;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Pages controller
 * @author Diego Andre Poli <diegoandrepoli@gmail.com>
 */
@Controller
public class PagesController {	

	/**
	 * Home page application
	 * @param http request
	 * @return name of view
	 */
	@RequestMapping(value="/")
	public String cart(HttpServletRequest request) {		
		return "index";
	}

}
