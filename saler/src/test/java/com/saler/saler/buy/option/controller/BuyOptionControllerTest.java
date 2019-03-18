package com.saler.saler.buy.option.controller;

import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.saler.saler.buy.option.entity.BuyOption;
import com.saler.saler.buy.option.service.BuyOptionService;
import com.saler.saler.utils.JsonStrinfy;

/**
 * Buy option controller test
 * @author Diego Andre Poli <diegoandrepoli@gmail.com>
 */
public class BuyOptionControllerTest {

	/**
	 * Mock as mvc
	 */
	private MockMvc mvc;

	/**
	 * Mock deal service
	 */
	@Mock
	private BuyOptionService buyOptionService;

	/**
	 * Mock deal controller
	 */
	@InjectMocks
	private BuyOptionController buyOptionController;

	/**
	 * Execute on before test
	 */
	@Before
	public void init() {
		//init mockito
		MockitoAnnotations.initMocks(this);
		
		//initialize controller
		mvc = MockMvcBuilders.standaloneSetup(buyOptionController).build();
	}

	/**
	 * Test get all buy options
	 * @throws Exception
	 */
	@Test
	public void testGetAllBuyOption() throws Exception {

		//create deal
		BuyOption option = new BuyOption();
		option.setId(new Long(223));
		option.setTitle("As title");
		option.setNormalPrice(new BigDecimal(30));
		option.setSalePrice(new BigDecimal(20));
		option.setPercentageDiscount(new BigDecimal(20));
		option.setQuantityCupom(new Long(30));
		option.setStartDate(new Date(new Long(43534)));
		option.setEndDate(new Date(new Long(43534)));
		
		//create deal list
		List<BuyOption> list = new ArrayList<BuyOption>();
		list.add(option);
		
		//get all on result service
		doReturn(list).when(buyOptionService).getAll();
		
		//perform test on get deal
		mvc.perform(get("/buy-option")			
			.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(content().string(JsonStrinfy.asJsonString(list)));				
	}
	
	/**
	 * Test get buy option
	 * @throws Exception
	 */
	@Test
	public void testGetBuyOption() throws Exception {

		//create deal
		BuyOption option = new BuyOption();
		option.setId(new Long(22));
		option.setTitle("As title");
		option.setNormalPrice(new BigDecimal(30));
		option.setSalePrice(new BigDecimal(20));
		option.setPercentageDiscount(new BigDecimal(20));
		option.setQuantityCupom(new Long(30));
		option.setStartDate(new Date(new Long(43534)));
		option.setEndDate(new Date(new Long(43534)));
			
		//get all on result service
		doReturn(option).when(buyOptionService).getById(option.getId());

		//perform test on get deal
		mvc.perform(get("/buy-option/22")			
			.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(content().string(JsonStrinfy.asJsonString(option)));		
	}
}
