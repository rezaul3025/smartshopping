/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.smart.shoping.persistence.services;

import java.util.List;
import org.smart.shoping.core.domain.Item;
import org.smart.shoping.core.domain.ItemCategory;
import org.smart.shoping.web.domain.ItemForm;
import org.smart.shoping.web.domain.ItemInfo;
import org.springframework.web.multipart.MultipartHttpServletRequest;

/**
 *
 * @author rkarim
 */
public interface ItemService {
    
    Item addShopingItem(ItemForm itemForm, Long businessId);
    
    void addItemImage(MultipartHttpServletRequest request, Long id);
    
    List<String> getItemCategory();
    
    List<ItemInfo> getItemByCategory(int page, int pageSize);
    
}
