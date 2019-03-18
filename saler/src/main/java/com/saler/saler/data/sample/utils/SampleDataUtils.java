package com.saler.saler.data.sample.utils;

import java.math.BigDecimal;
import java.util.Date;

import com.saler.saler.buy.option.entity.BuyOption;
import com.saler.saler.deal.entity.Deal;

/**
 * Sample data utils
 * @author Diego Andre Poli <diegoandrepoli@gmail.com>
 */
public class SampleDataUtils {
	
	/**
	 * Ger sample date as now
	 * @return now as date
	 */
	private static Date getSampleDate() {
		return new Date();
	}
	
	/**
	 * Get sample pergentage discount
	 * @return percetage discount as bigdecimal
	 */
	private static BigDecimal getSamplePercentageDiscount() {
		return new BigDecimal(20);
	}

	/**
	 * Get sample data quantity
	 * @return quantity as long
	 */
	private static long getSampleDataQuantity() {
		return 1000L;
	}
	
	/**
	 * Generate deal
	 * @param deal title
	 * @param deal text
	 * @param deal type
	 * @param deal url
	 * @return deal
	 */
	public static Deal generateDeal(String title, String text, String type, String url) {
		Deal deal = new Deal();	
		deal.setTitle(title);
		deal.setText(text);
		deal.setPublishDate(getSampleDate());
		deal.setEndDate(getSampleDate());
		deal.setUrl(url);
		deal.setType(type);
		deal.setTotalSold(0L);
		
		return deal;
	}
	
	/**
	 * Generate buy option
	 * @param buy title
	 * @param buy normal price
	 * @param buy sale price
	 * @return buy option
	 */
	public static BuyOption generateBuyOption(String title, BigDecimal normalPrice, BigDecimal salePrice) {		
		BuyOption option = new BuyOption();			
		option.setTitle(title);
		option.setNormalPrice(normalPrice);
		option.setSalePrice(salePrice);
		option.setPercentageDiscount(getSamplePercentageDiscount());
		option.setStartDate(getSampleDate());
		option.setEndDate(getSampleDate());
		option.setQuantityCupom(getSampleDataQuantity());
		
		return option;
	}

}
