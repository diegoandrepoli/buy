package com.saler.saler.deal.type.utils;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.saler.saler.deal.type.entity.DealType;
import com.saler.saler.deal.type.enums.DealTypeEnum;

/**
 * Deal enum test
 * @author Diego Andre Poli	<diegoandrepoli@gmail.com>
 */
public class DealTypeUtilsTest {
	
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
		
		//create enum test vaues
		List<DealType> list = new ArrayList<DealType>();
		list.add(new DealType(DealTypeEnum.OFF.getKey(), DealTypeEnum.OFF.getValue()));
		list.add(new DealType(DealTypeEnum.PRM.getKey(), DealTypeEnum.PRM.getValue()));
		list.add(new DealType(DealTypeEnum.LQA.getKey(), DealTypeEnum.LQA.getValue()));
		
		//generate output
		List<DealType> result = DealTypeUtils.objects();
		
		//compare keys
		assertEquals(result.get(0).getKey(), DealTypeEnum.OFF.getKey());
		assertEquals(result.get(1).getKey(), DealTypeEnum.PRM.getKey());
		assertEquals(result.get(2).getKey(), DealTypeEnum.LQA.getKey());
		
		//compare values
		assertEquals(result.get(0).getValue(), DealTypeEnum.OFF.getValue());
		assertEquals(result.get(1).getValue(), DealTypeEnum.PRM.getValue());
		assertEquals(result.get(2).getValue(), DealTypeEnum.LQA.getValue());
	}

}
