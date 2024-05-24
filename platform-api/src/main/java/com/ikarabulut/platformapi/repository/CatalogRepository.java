package com.ikarabulut.platformapi.repository;

import com.ikarabulut.platformapi.common.models.CatalogDetails;
import org.springframework.data.repository.CrudRepository;

public interface CatalogRepository extends CrudRepository<CatalogDetails, Long> {}
