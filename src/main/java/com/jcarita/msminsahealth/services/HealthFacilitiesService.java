package com.jcarita.msminsahealth.services;

import com.jcarita.msminsahealth.model.HealthFacilitiesEntity;
import com.jcarita.msminsahealth.repository.IHealthFacilitiesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class HealthFacilitiesService implements IHealthFacilitiesService{

    private final IHealthFacilitiesRepository healthFacilitiesRepository;

    @Override
    public List<HealthFacilitiesEntity> getAll() {
        return healthFacilitiesRepository.findAll();
    }

    @Override
    public Optional<HealthFacilitiesEntity> findById(Long id) {
        return healthFacilitiesRepository.findById(id);
    }

    @Override
    public List<HealthFacilitiesEntity> getAllByUbigeo(String ubigeo) {
        return healthFacilitiesRepository.findByUbigeoCode(ubigeo);
    }

    @Override
    public List<HealthFacilitiesEntity> findByRegion(String region) {
        return healthFacilitiesRepository.findByDescription(region);
    }

    @Override
    public List<HealthFacilitiesEntity> findByRed(String red) {
        return healthFacilitiesRepository.findByRed(red);
    }

    @Override
    public List<HealthFacilitiesEntity> findByCategory(String category) {
        return healthFacilitiesRepository.findByCategory(category);
    }
}
