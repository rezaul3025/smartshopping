/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.smart.shoping.web.controller.rest;

import org.smart.shoping.persistence.services.ItemService;
import org.smart.shoping.web.domain.ItemInfoList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author rkarim
 */
@RestController
@RequestMapping(value = "/rest/item")
public class ItemRestController {
    
    @Autowired
    private ItemService itemService;
    
    @RequestMapping(value="/all", method = RequestMethod.GET)
    public ItemInfoList getAllItem(@RequestParam("page") int page, @RequestParam("pageSize") int pageSize){
        return itemService.getAll(page, pageSize);
    }
}
