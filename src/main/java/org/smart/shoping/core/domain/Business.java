package org.smart.shoping.core.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity(name = "business")
public class Business implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", length = Integer.MAX_VALUE, nullable = false)
    private Long id;

    @Column(name = "title", length = 255, nullable = false)
    private String title;

    @Column(name = "sub_title", length = 255, nullable = true)
    private String subTitle;

    @Column(name = "description", length = Integer.MAX_VALUE, nullable = false)
    private String description;

    @Column(name = "street_name_no", length = 126, nullable = false)
    private String streetNameAndNo;

    @Column(name = "location", length = 255, nullable = true)
    private String location;

    @Column(name = "floor_no", length = 3, nullable = true)
    private Integer floorNo;

    @Column(name = "shop_no", length = 6, nullable = true)
    private Integer shopNo;

    @Column(name = "post_code", length = 10, nullable = true)
    private Integer postCode;

    @Column(name = "city", length = 80, nullable = false)
    private String city;

    @Column(name = "country", length = 100, nullable = false)
    private String country;

    @Column(name = "email", length = 100, nullable = false)
    private String email;

    @Column(name = "phone", length = 50, nullable = false)
    private String phone;

    @Column(name = "password", length = 20, nullable = false)
    private String password;

    @OneToMany(mappedBy = "business")
    @JsonManagedReference
    private List<BusinessImageMeta> businessImageMeta;

    public Business() {

    }

    public Business(Long id) {
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

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getStreetNameAndNo() {
        return streetNameAndNo;
    }

    public void setStreetNameAndNo(String streetNameAndNo) {
        this.streetNameAndNo = streetNameAndNo;
    }

    public Integer getFloorNo() {
        return floorNo;
    }

    public void setFloorNo(Integer floorNo) {
        this.floorNo = floorNo;
    }

    public Integer getShopNo() {
        return shopNo;
    }

    public void setShopNo(Integer shopNo) {
        this.shopNo = shopNo;
    }

    public Integer getPostCode() {
        return postCode;
    }

    public void setPostCode(Integer postCode) {
        this.postCode = postCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<BusinessImageMeta> getBusinessImageMeta() {
        return businessImageMeta;
    }

    public void setBusinessImageMeta(List<BusinessImageMeta> businessImageMeta) {
        this.businessImageMeta = businessImageMeta;
    }

}
