package org.smart.shoping.persistence.repositories;

import java.util.List;

import org.smart.shoping.core.domain.Business;
import org.smart.shoping.core.domain.BusinessImageMeta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusinessImageMetaRepository extends JpaRepository<BusinessImageMeta, Long> {
	public List<BusinessImageMeta> findByBusiness(Business business);
}
