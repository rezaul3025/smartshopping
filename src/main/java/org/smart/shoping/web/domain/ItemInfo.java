/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.smart.shoping.web.domain;

import java.util.ArrayList;
import java.util.List;
import org.smart.shoping.core.domain.Category;
import org.smart.shoping.core.domain.Item;

/**
 *
 * @author rkarim
 */
public class ItemInfo {
    
    private Category category;
    private List<Item> content=new ArrayList<Item>();
    private  Long totalItem;
    
    public ItemInfo(Category category, List<Item> content, Long totalItem)
    {
        this.category = category;
        this.content = content;
        this.totalItem = totalItem;
    }
    
    public ItemInfo()
    {
        
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
    
    

    public List<Item> getContent() {
        return content;
    }

    public void setContent(List<Item> content) {
        this.content = content;
    }

    public Long getTotalItem() {
        return totalItem;
    }

    public void setTotalItem(Long totalItem) {
        this.totalItem = totalItem;
    }
    
    
}
