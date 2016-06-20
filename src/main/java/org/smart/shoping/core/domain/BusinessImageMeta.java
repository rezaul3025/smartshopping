package org.smart.shoping.core.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity(name="business_image_meta")
public class BusinessImageMeta extends ImageMeta {
	
	@Column(name="image_type", length=10, nullable=false)
	private String imageType;
	
	@ManyToOne
	@JsonBackReference
	@JoinColumn(name="owner_id")
	private Business business;

	
	public BusinessImageMeta(){
		
	}
	
	public BusinessImageMeta(Long id, Business business, String webPath, String originalPath, String ownerType, String imageType, Integer height, Integer width, Long size, String format, String name){
		this.setId(id);
		this.setBusiness(business);
		this.setWebPath(webPath);
		this.setOriginalPath(originalPath);
		this.setOwnerType(ownerType);
		this.imageType = imageType;
		this.setHeight(height);
		this.setWidth(width);
		this.setSize(size);
		this.setFormat(format);
		this.setName(name);
	}

	public String getImageType() {
		return imageType;
	}

	public void setImageType(String imageType) {
		this.imageType = imageType;
	}

	public Business getBusiness() {
		return business;
	}

	public void setBusiness(Business business) {
		this.business = business;
	}

}
