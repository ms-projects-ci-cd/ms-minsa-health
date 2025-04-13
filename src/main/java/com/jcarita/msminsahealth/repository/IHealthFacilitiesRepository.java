package com.jcarita.msminsahealth.repository;

import com.jcarita.msminsahealth.model.HealthFacilitiesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IHealthFacilitiesRepository extends JpaRepository<HealthFacilitiesEntity, Long> {
    List<HealthFacilitiesEntity> findByUbigeoCode(String ubigeoCode);

    List<HealthFacilitiesEntity> findByRed(String red);

    List<HealthFacilitiesEntity> findByCategory(String category);

    List<HealthFacilitiesEntity> findByDescription(String description);
}
