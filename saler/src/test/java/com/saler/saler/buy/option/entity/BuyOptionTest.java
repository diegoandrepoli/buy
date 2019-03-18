package com.saler.saler.buy.option.entity;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.sql.Date;

import org.junit.Before;
import org.junit.Test;

/**
 * Buy option test
 * @author Diego Andre Poli <diegoandrepoli@gmail.com>
 */
public class BuyOptionTest {
	
	/**
	 * Test init
	 */
	@Before
	public void init() {}
	
	/**
	 * Test get and setter methods
	 * @throws Exception
	 */

	@Test
	public void testGetAndSetters() throws Exception {
		
		//create buy option
		BuyOption buyOption = new BuyOption();		
		buyOption.setId(new Long(6));
		buyOption.setTitle("As title");
		buyOption.setNormalPrice(new BigDecimal(40.20));
		buyOption.setSalePrice(new BigDecimal(40.10));
		buyOption.setPercentageDiscount(new BigDecimal(4));
		buyOption.setQuantityCupom(new Long(4));
		buyOption.setStartDate(new Date(34235L));
		buyOption.setEndDate(new Date(34235L));
		
		//test values
		assertEquals(new Long(6), buyOption.getId());	
		assertEquals("As title", buyOption.getTitle());
		assertEquals(new BigDecimal(40.20), buyOption.getNormalPrice());
		assertEquals(new BigDecimal(40.10), buyOption.getSalePrice());
		assertEquals(new BigDecimal(4), buyOption.getPercentageDiscount());
		assertEquals(new Long(4), buyOption.getQuantityCupom());
		assertEquals(new Date(34235L), buyOption.getStartDate());
		assertEquals(new Date(34235L), buyOption.getEndDate());
	}
	
}

