/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.smart.shoping.persistence.services;

import org.smart.shoping.core.domain.Item;
import org.springframework.web.multipart.MultipartHttpServletRequest;

/**
 *
 * @author rkarim
 */
public interface ItemService {
    
    Item addShopingItem(Item item, Long businessId);
    
    void addItemImage(MultipartHttpServletRequest request, Long id);
    
}
