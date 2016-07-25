/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.smart.shoping.core.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 *
 * @author rkarim
 */
@Entity(name="item_category")
public class ItemCategory implements Serializable{
    
    @Id
    @Column(name="id")
    private Integer id;
    
    @Column(name="name", length = 255)
    private String name;
    
    @Column(name="image_icon", length = 255)
    private String imageIcon;
    
    @OneToMany(mappedBy = "itemCategory")
   // @JsonManagedReference
    @JsonBackReference
    private List<Item> items;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageIcon() {
        return imageIcon;
    }

    public void setImageIcon(String imageIcon) {
        this.imageIcon = imageIcon;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
