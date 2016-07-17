/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.smart.shoping.persistence.services;

import java.util.List;
import java.util.Set;
import org.smart.shoping.core.domain.Item;
import org.smart.shoping.web.domain.ItemInfoList;
import org.springframework.web.multipart.MultipartHttpServletRequest;

/**
 *
 * @author rkarim
 */
public interface ItemService {
    
    Item addShopingItem(Item item, Long businessId);
    
    void addItemImage(MultipartHttpServletRequest request, Long id);
    
    ItemInfoList getAll(int page, int pageSize);
    
}
