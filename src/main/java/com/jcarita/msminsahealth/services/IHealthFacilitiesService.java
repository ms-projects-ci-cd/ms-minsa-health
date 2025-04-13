package com.jcarita.msminsahealth.services;

import com.jcarita.msminsahealth.model.HealthFacilitiesEntity;

import java.util.List;
import java.util.Optional;

public interface IHealthFacilitiesService {

    List<HealthFacilitiesEntity> getAll();
    Optional<HealthFacilitiesEntity> findById(Long id);
    List<HealthFacilitiesEntity> getAllByUbigeo(String ubigeo);
    List<HealthFacilitiesEntity> findByRegion(String region);
    List<HealthFacilitiesEntity> findByRed(String red);
    List<HealthFacilitiesEntity> findByCategory(String category);
}
