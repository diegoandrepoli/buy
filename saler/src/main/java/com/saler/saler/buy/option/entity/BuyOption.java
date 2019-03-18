package com.saler.saler.buy.option.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Buy option entity
 * @author Diego Andre Poli <diegoandrepoli@gmail.com>
 */
@Entity
public class BuyOption {
	
	/**
	 * Identifier
	 */
	@Id
	@GeneratedValue
	private Long id;

	
	/**
	 * Buy option title
	 */
	private String title;
	
	/**
	 * Buy option normal price
	 */
	private BigDecimal normalPrice;
	
	/**
	 * Buy option sale price
	 */
	private BigDecimal salePrice;
	
	/**
	 * Buy option percentage discount
	 */
	private BigDecimal percentageDiscount;
	
	/**
	 * Buy oprion quantity cupon
	 */
	private Long quantityCupom;
	
	/**
	 * Buy option start date
	 */
	private Date startDate;
	
	/**
	 * Buy option end date
	 */
	private Date endDate;

	/**
	 * Get buy option id
	 * @return id of buy option
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Set buy option id
	 * @param id of buy option
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Get buy option title
	 * @return title od buy option
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Set buy option title
	 * @param title of buy option
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Ger buy option normal price
	 * @return normal price of buy option
	 */
	public BigDecimal getNormalPrice() {
		return normalPrice;
	}

	/**
	 * Ser buy option normal price
	 * @param normal price of buy option
	 */
	public void setNormalPrice(BigDecimal normalPrice) {
		this.normalPrice = normalPrice;
	}

	/**
	 * Set buy option sale price
	 * @return sale price of buy option
	 */
	public BigDecimal getSalePrice() {
		return salePrice;
	}

	/**
	 * Ser buy option sale price
	 * @param sale price of buy option
	 */
	public void setSalePrice(BigDecimal salePrice) {
		this.salePrice = salePrice;
	}

	/**
	 * Get buy option percentage discount
	 * @return percentage discount of buy option
	 */
	public BigDecimal getPercentageDiscount() {
		return percentageDiscount;
	}

	/**
	 * Set buy option percentage discount
	 * @param percentage biscount of percent discount
	 */
	public void setPercentageDiscount(BigDecimal percentageDiscount) {
		this.percentageDiscount = percentageDiscount;
	}

	/**
	 * Get quantity cupom
	 * @return buy option quantity cupom
	 */
	public Long getQuantityCupom() {
		return quantityCupom;
	}

	/**
	 * Set buy option quantity cupom 
	 * @param buy option quantity cupom 
	 */
	public void setQuantityCupom(Long quantityCupom) {
		this.quantityCupom = quantityCupom;
	}

	/**
	 * Get buy option start date
	 * @return buy option start date
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * Set buy option start date
	 * @param buy option start date
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * Get buy option end date
	 * @return buy option end date
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * Set buy option end date
	 * @parambuy option end date
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

}
