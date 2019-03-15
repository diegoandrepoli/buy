package com.saler.saler.deal.enums;

import java.util.ArrayList;
import java.util.List;

import com.saler.saler.deal.entity.DealType;

/**
 * Deal type enums
 * @author Diego Andre Poli <diegoandrepoli@gmail.com>
 */
public enum DealTypeEnum {
	
	OFF("OF1", "Oferta"),
	PRM("PRM", "Promoção"),
	LQA("LQA", "Liquidação");
	
	/**
	 * Key of enum
	 */
	private String key;
	
	/**
	 * Value of enum
	 */
	private String value;
	
	/**
	 * Default constructor
	 * @param key of enum
	 * @param value of enum
	 */
	DealTypeEnum(String key, String value){
		this.key = key;
		this.value = value;
	}

	/**
	 * Get key
	 * @return key as string
	 */
	public String getKey() {
		return key;
	}

	/**
	 * Set key
	 * @param key as string
	 */
	public void setKey(String key) {
		this.key = key;
	}

	/**
	 * Get value
	 * @return value as string
	 */
	public String getValue() {
		return value;
	}

	/**
	 * Set value
	 * @param value as string
	 */
	public void setValue(String value) {
		this.value = value;
	}
	
	/**
	 * Objects of deal emums
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
