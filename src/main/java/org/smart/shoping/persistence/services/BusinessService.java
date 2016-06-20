package org.smart.shoping.persistence.services;

import java.util.List;

import org.smart.shoping.core.domain.Business;
import org.smart.shoping.core.domain.BusinessImageMeta;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartHttpServletRequest;

public interface BusinessService {
	public Business addBusiness(Business business);
	public void imageUpload(MultipartHttpServletRequest request, Long id);
	public List<BusinessImageMeta> getImageByBusiness(Long id);
	
	public Page<Business> getAll(Pageable pageArg);
}
