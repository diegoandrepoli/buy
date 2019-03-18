package com.saler.saler.deal.type.entity;

/**
 * Deal type entity
 * @author Diego Andre Poli <diegoandrepoli@gmail.com>
 */
public class DealType {
	
	/**
	 * Key of deal type
	 */
	private String key;
	
	/**
	 * Value of deal type
	 */
	private String value;
	
	/**
	 * Custom deal type constructor
	 * @param deal type key 
	 * @param deal type value
	 */
	public DealType(String key, String value) {
		this.key = key;
		this.value = value;
	}

	/**
	 * Get deal type key
	 * @return deal type key
	 */
	public String getKey() {
		return key;
	}

	/**
	 * Set deal type key
	 * @param deal type key
	 */
	public void setKey(String key) {
		this.key = key;
	}

	/**
	 * Get deal type value 
	 * @return deal type value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * Set deal type value 
	 * @param deal type value
	 */
	public void setValue(String value) {
		this.value = value;
	}
	
}
