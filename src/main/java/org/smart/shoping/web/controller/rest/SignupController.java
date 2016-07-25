/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.smart.shoping.web.controller.rest;

import org.smart.shoping.persistence.services.BusinessService;
import org.smart.shoping.web.domain.BusinessForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartHttpServletRequest;

/**
 *
 * @author rkarim
 */
@RestController
@RequestMapping("/rest/signup")
public class SignupController {
    
    @Autowired
    private BusinessService businessService;

    @RequestMapping(value = "/business", method = RequestMethod.POST)
    public Long signUp(@RequestBody BusinessForm businessForm) {
        //executor.execute(longRunningService);
        return businessService.addBusiness(businessForm).getId();
    }

    @RequestMapping(value = "/business/image/{id}", method = RequestMethod.POST)
    public void businessImageUploadWithSignup(MultipartHttpServletRequest request, @PathVariable("id") Long businessId) {
        businessService.imageUpload(request, businessId);
    }
}
