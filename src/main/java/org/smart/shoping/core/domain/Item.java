package org.smart.shoping.core.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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

    @Column(name = "title", length = 255, nullable = false)
    private String title;

    @Column(name = "description", length = Integer.MAX_VALUE, nullable = false)
    private String description;

    @Column(name = "created_date", length = 6, nullable = false)
    private Date createdDate;

    @Column(name = "offer", length = 10, nullable = true)
    private Boolean offer;

    @Column(name = "price", precision = 2, length = 10, nullable = false)
    private Float price;

    @Column(name = "offer_price", precision = 2, length = 10, nullable = true)
    private Float offerPrice;

    @Column(name = "quantity", length = 10, nullable = true)
    private Integer quantity;

    //@Column(name = "category", length = 255, nullable = false)
    //private Category category;
    
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "owner_id" , nullable = false,unique = false)
    private Business business;

    @OneToMany(mappedBy = "item")
    @JsonManagedReference
    private Set<ItemImageMeta> itemImageMeta;
    
    @ManyToOne
   // @JsonBackReference
    @JsonManagedReference
    @JoinColumn(name = "category" , nullable = false,unique = false)
    private ItemCategory itemCategory;
    
    public Item(){
        
    }
    
    public Item(String title, String description, Date createdDate, Boolean offer, Float price, Float offerPrice, Integer quantity){
        this.title = title;
        this.description = description;
        this.createdDate = createdDate;
        this.offer = offer;
        this.price = price;
        this.offerPrice = offerPrice;
        this.quantity = quantity;
    }
    
    public Item(Long id){
        this.id = id;
    }

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

    public Set<ItemImageMeta> getItemImageMeta() {
        return itemImageMeta;
    }

    public void setItemImageMeta(Set<ItemImageMeta> itemImageMeta) {
        this.itemImageMeta = itemImageMeta;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public Business getBusiness() {
        return business;
    }

    public void setBusiness(Business business) {
        this.business = business;
    }

    public ItemCategory getItemCategory() {
        return itemCategory;
    }

    public void setItemCategory(ItemCategory itemCategory) {
        this.itemCategory = itemCategory;
    }
}
