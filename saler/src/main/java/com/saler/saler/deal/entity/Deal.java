package com.saler.saler.deal.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.UpdateTimestamp;

import com.saler.saler.buy.option.entity.BuyOption;

/**
 * Deal entity
 * @author Diego Andre Poli <diegoandrepoli@gmail.com>
 */
@Entity
public class Deal {
	
	/**
	 * Deal identification
	 */
	@Id
	@GeneratedValue
	private Long id;
	
	/**
	 * List of buy option
	 */
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	private List<BuyOption> buyOptions = new ArrayList<>();
	
	/**
	 * Deal title
	 */
	private String title;
	
	/**
	 * Deal text
	 */
	private String text;
	
	/**
	 * Deal create date
	 */
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate;
	
	/**
	 * Deal publish date
	 */
	@Temporal(TemporalType.TIMESTAMP)
	private Date publishDate;
	
	/**
	 * Deal end date
	 */
	@Temporal(TemporalType.TIMESTAMP)
	private Date endDate;
	
	/**
	 * Deal url
	 */
	private String url;
	
	/**
	 * Deal total sold
	 */
	private Long totalSold;
	
	/**
	 * Deal type
	 */
	private String type;

	/**
	 * Get deal id
	 * @return id from deal
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Set deal lid
	 * @param id from deal
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Get deal title
	 * @return title from deal
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Set deal title
	 * @param title from deal
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Get deal text
	 * @return text from deal
	 */
	public String getText() {
		return text;
	}

	/**
	 * Set deal text
	 * @param text from deal
	 */
	public void setText(String text) {
		this.text = text;
	}

	/**
	 * Get deal create date
	 * @return date of deal create
	 */
	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * Set deal create date
	 * @param date of deal create
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	/**
	 * Get deal publish date
	 * @return date of deal publish
	 */
	public Date getPublishDate() {
		return publishDate;
	}

	/**
	 * Set deal publish date
	 * @return date of deal publish
	 */
	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

	/**
	 * Get deal end date
	 * @return deal end date
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * Set deal end date
	 * @return deal end date
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	/**
	 * Get total sold of deal
	 * @return deal total sold
	 */
	public Long getTotalSold() {
		return totalSold;
	}

	/**
	 * Set total sold of deal
	 * @return deal total sold
	 */
	public void setTotalSold(Long totalSold) {
		this.totalSold = totalSold;
	}

	/**
	 * Get deal type
	 * @return type of deal
	 */
	public String getType() {
		return type;
	}

	/**
	 * Set deal type
	 * @param type of deal
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * Get deal url
	 * @return url of deal
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * Set deal url
	 * @param url of deal
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * Get buy options
	 * @return list of buy options
	 */
	public List<BuyOption> getBuyOptions() {
		return buyOptions;
	}

	/**
	 * Set buy options
	 * @param buy options
	 */
	public void setBuyOptions(List<BuyOption> buyOptions) {
		this.buyOptions = buyOptions;
	}
	
	/**
	 * Set merge buy option
	 * @param list of buy options
	 */
	public void setMergeBuyOptions(List<BuyOption> buyOptions) {
		for(BuyOption option : buyOptions) {			
			this.buyOptions.add(option);
		}
	}
	
	/**
	 * Add buy option 
	 * @param buy option
	 */
	public void addBuyOption(BuyOption buyOption) {		
		this.buyOptions.add(buyOption);
	}
	
}
