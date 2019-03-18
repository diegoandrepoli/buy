package com.saler.saler.deal.type.utils;

import java.util.ArrayList;
import java.util.List;

import com.saler.saler.deal.type.entity.DealType;
import com.saler.saler.deal.type.enums.DealTypeEnum;

/**
 * Deal type utils
 * @author Diego Andre Poli <diegoandrepoli@gmail.com>
 */
public class DealTypeUtils {
	
	/**
	 * Objects of deal emums
	 * TODO: use lambda to perform
	 * @return list of deals
	 */
	public static List<DealType> objects() {
		List<DealType> list = new ArrayList<DealType>();
		
		for(DealTypeEnum en : DealTypeEnum.values()) {
			list.add(new DealType(en.getKey(), en.getValue()));
		}
		
		return list;
	}
	
}
