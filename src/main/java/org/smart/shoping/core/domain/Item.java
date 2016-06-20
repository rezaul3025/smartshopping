package org.smart.shoping.core.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity(name = "item")
public class Item implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2352039635829653223L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", length = Integer.MAX_VALUE, nullable = false)
	private Long id;
	
	@Column(name="title", length=255, nullable=false)
	private String title;
	
	@Column(name="description", length=Integer.MAX_VALUE, nullable=false)
	private String description;
	
	@Column(name="created_date", length=6, nullable=false)
	private Date createdDate;
	
	@Column(name="offer", length=10, nullable=true)
	private Boolean offer;
	
	@Column(name="price", precision=2, length=10, nullable=false)
	private Float price;
	
	@Column(name="offer_price", precision=2, length=10, nullable=true)
	private Float offerPrice;
	
	@Column(name="quantity", length=10, nullable=true)
	private Integer quantity;
	
	@Column(name="category", length=255, nullable=false)
	private Category category;
	
	@OneToMany(mappedBy="item")
	@JsonManagedReference
	private Set<ItemImageMeta> itemImageMeta;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Boolean getOffer() {
		return offer;
	}

	public void setOffer(Boolean offer) {
		this.offer = offer;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Float getOfferPrice() {
		return offerPrice;
	}

	public void setOfferPrice(Float offerPrice) {
		this.offerPrice = offerPrice;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Set<ItemImageMeta> getItemImageMeta() {
		return itemImageMeta;
	}

	public void setItemImageMeta(Set<ItemImageMeta> itemImageMeta) {
		this.itemImageMeta = itemImageMeta;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
