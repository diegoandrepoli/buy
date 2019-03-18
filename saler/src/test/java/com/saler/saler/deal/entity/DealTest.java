package com.saler.saler.deal.entity;

import static org.junit.Assert.assertEquals;

import java.sql.Date;

import org.junit.Before;
import org.junit.Test;

import com.saler.saler.deal.entity.Deal;

/**
 * Deal entity test
 * @author Diego Andre Poli <diegoandrepoli@gmail.com>
 */
public class DealTest {
	
	/**
	 * On init tests
	 */
	@Before
	public void init() {}
	
	/**
	 * Test get and setters
	 * @throws Exception
	 */
	@Test
	public void testGetAndSetters() throws Exception {
		
		//create deal
		Deal deal = new Deal();
		deal.setId(new Long(34234));
		deal.setTitle("As title");
		deal.setText("As text");
		deal.setCreateDate(new Date(2345L));
		deal.setPublishDate(new Date(2345L));
		deal.setEndDate(new Date(2345L));
		
		//assert values
		assertEquals(new Long(34234), deal.getId());
		assertEquals("As title", deal.getTitle());
		assertEquals("As text", deal.getText());
		assertEquals(new Date(2345L), deal.getCreateDate());
		assertEquals(new Date(2345L), deal.getPublishDate());
		assertEquals(new Date(2345L), deal.getEndDate());		
	}

}

