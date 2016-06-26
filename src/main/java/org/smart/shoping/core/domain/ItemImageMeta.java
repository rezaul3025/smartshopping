package org.smart.shoping.core.domain;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;

/**
 *
 * @author rkarim
 */
@Entity(name = "item_image_meta")
public class ItemImageMeta extends ImageMeta implements Serializable {

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "owner_id" , nullable = false,unique = false)
    private Item item;

    public ItemImageMeta() {

    }

    public ItemImageMeta(Long id, Item item, String webPath, String originalPath, String imageType, Integer height, Integer width, Long size, String format, String name) {
        this.setId(id);
        this.setItem(item);
        this.setWebPath(webPath);
        this.setOriginalPath(originalPath);
        this.setImageType(imageType);
        this.setHeight(height);
        this.setWidth(width);
        this.setSize(size);
        this.setFormat(format);
        this.setName(name);
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

}
