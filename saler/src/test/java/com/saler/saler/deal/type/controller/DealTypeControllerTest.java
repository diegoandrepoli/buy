package com.saler.saler.deal.type.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.saler.saler.deal.type.entity.DealType;
import com.saler.saler.deal.type.utils.DealTypeUtils;
import com.saler.saler.utils.JsonStrinfy;

/**
 * Deal controller test
 * @author Diego Andre Poli <diegoandrepoli@gmail.com>
 */
public class DealTypeControllerTest {

	/**
	 * Mock as mvc
	 */
	private MockMvc mvc;

	/**
	 * Mock deal controller
	 */
	@InjectMocks
	private DealTypeController dealTypeController;

	/**
	 * Execute on before test
	 */
	@Before
	public void init() {
		//init mockito
		MockitoAnnotations.initMocks(this);
		
		//initialize controller
		mvc = MockMvcBuilders.standaloneSetup(dealTypeController).build();
	}

	/**
	 * Test get deal method
	 * @throws Exception
	 */
	@Test
	public void testGetDeal() throws Exception {

		//create deal
		List<DealType> objects = DealTypeUtils.objects();
		
		//perform test on get deal
		mvc.perform(get("/type")			
			.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(content().string(JsonStrinfy.asJsonString(objects)));				
	}
	
}
