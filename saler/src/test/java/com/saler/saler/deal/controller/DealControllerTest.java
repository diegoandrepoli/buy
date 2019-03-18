package com.saler.saler.deal.controller;

import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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

import com.saler.saler.deal.controller.DealController;
import com.saler.saler.deal.entity.Deal;
import com.saler.saler.deal.service.DealService;
import com.saler.saler.utils.JsonStrinfy;

/**
 * Deal controller test
 * @author Diego Andre Poli <diegoandrepoli@gmail.com>
 */
public class DealControllerTest {

	/**
	 * Mock as mvc
	 */
	private MockMvc mvc;

	/**
	 * Mock deal service
	 */
	@Mock
	private DealService dealService;

	/**
	 * Mock deal controller
	 */
	@InjectMocks
	private DealController dealController;

	/**
	 * Execute on before test
	 */
	@Before
	public void init() {
		//init mockito
		MockitoAnnotations.initMocks(this);
		
		//initialize controller
		mvc = MockMvcBuilders.standaloneSetup(dealController).build();
	}

	/**
	 * Test get deal method
	 * @throws Exception
	 */
	@Test
	public void testGetAllDeal() throws Exception {

		//create deal
		Deal deal = new Deal();
		deal.setText("As text");
		deal.setTitle("As title");
		
		//create deal list
		List<Deal> list = new ArrayList<Deal>();
		list.add(deal);
		
		//get all on result service
		doReturn(list).when(dealService).getAll();
		
		//perform test on get deal
		mvc.perform(get("/deal")			
			.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(content().string(JsonStrinfy.asJsonString(list)));				
	}
	
	@Test
	public void testPostDeal() throws Exception {

		//create deal
		Deal deal = new Deal();
		deal.setText("As text");
		deal.setTitle("As title");
			
		//get all on result service
		doReturn(deal).when(dealService).add(deal);
		
		//perform test on post deal
		mvc.perform(post("/deal/add")			
			.contentType(MediaType.APPLICATION_JSON)
			.content(JsonStrinfy.asJsonString(deal)))
			.andExpect(status().isOk());				
	}
	
	/**
	 * Test get deal
	 * @throws Exception
	 */
	@Test
	public void testGetDeal() throws Exception {

		//create deal
		Deal deal = new Deal();
		deal.setId(new Long(23));
		deal.setText("As text");
		deal.setTitle("As title");
			
		//get all on result service
		doReturn(deal).when(dealService).getById(deal.getId());

		//perform test on get deal
		mvc.perform(get("/deal/23")			
			.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(content().string(JsonStrinfy.asJsonString(deal)));		
	}

}
