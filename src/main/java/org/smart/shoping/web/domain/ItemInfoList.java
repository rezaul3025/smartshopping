/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.smart.shoping.web.domain;

import java.util.ArrayList;
import java.util.List;
import org.smart.shoping.core.domain.Item;

/**
 *
 * @author rkarim
 */
public class ItemInfoList {
    private List<Item> content=new ArrayList<Item>();
    private  Long totalItem;
    
    public ItemInfoList(List<Item> content, Long totalItem)
    {
        this.content = content;
        this.totalItem = totalItem;
    }
    
    public ItemInfoList()
    {
        
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
