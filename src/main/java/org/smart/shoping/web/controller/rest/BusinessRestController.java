package org.smart.shoping.web.controller.rest;

import java.util.List;

import org.smart.shoping.core.domain.Business;
import org.smart.shoping.core.domain.BusinessImageMeta;
import org.smart.shoping.persistence.services.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@RestController
@RequestMapping("/rest/business")
public class BusinessRestController {

    @Autowired
    private BusinessService businessService;

    //@Autowired
    //private LongRunningService longRunningService;
    //final  ExecutorService executor = Executors.newSingleThreadExecutor();
    @RequestMapping(value = "/all")
    public List<Business> getAll() {
        //Pageable page = new Pageable();
        return businessService.getAll(new PageRequest(0, 10, Sort.Direction.DESC, "title")).getContent();
    }

    @RequestMapping(value = "/image/{id}", method = RequestMethod.GET)
    public List<BusinessImageMeta> getBusinessImage(@PathVariable("id") Long id) {
        //executor.shutdown();
        //executor.shutdownNow();
        return businessService.getImageByBusiness(id);
    }

    @RequestMapping(value = "/name", method = RequestMethod.GET)
    public List<Business> getBissinessTitle(@RequestParam("query") String searchTerm) {
        return businessService.getAll(new PageRequest(0, 10, Sort.Direction.DESC, "title")).getContent();//.stream().map(Business :: getTitle).collect(Collectors.toList());
    }

}
