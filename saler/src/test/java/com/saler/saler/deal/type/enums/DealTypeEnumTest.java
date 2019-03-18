package com.saler.saler.deal.type.enums;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.saler.saler.deal.type.enums.DealTypeEnum;

/**
 * Deal enum test
 * @author Diego Andre Poli	<diegoandrepoli@gmail.com>
 */
public class DealTypeEnumTest {
	
	/**
	 * Init test
	 */
	@Before
	public void init() {}
	
	/**
	 * Test objects enumeratos
	 */
	@Test
	public void testObjects() {
		
		//compare keys
		assertEquals("OF1", DealTypeEnum.OFF.getKey());
		assertEquals("PRM", DealTypeEnum.PRM.getKey());
		assertEquals("LQA", DealTypeEnum.LQA.getKey());
		
		//compare values
		assertEquals("Oferta", DealTypeEnum.OFF.getValue());
		assertEquals("Promoção", DealTypeEnum.PRM.getValue());
		assertEquals("Liquidação", DealTypeEnum.LQA.getValue());
	}

}
