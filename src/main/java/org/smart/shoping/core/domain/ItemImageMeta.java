package org.smart.shoping.core.domain;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity(name="item_image_meta")
public class ItemImageMeta extends ImageMeta {
	
	@ManyToOne
	@JsonBackReference
	@JoinColumn(name="owner_id")
	private Item item;

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	
}
