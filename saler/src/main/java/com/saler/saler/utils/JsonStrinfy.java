package com.saler.saler.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Stringfy json as object
 * @author Diego Andre Poli <diegoandrepoli@gmail.com>
 */
public class JsonStrinfy {

	/**
	 * Object as json
	 * @param object
	 * @return json
	 */
	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
