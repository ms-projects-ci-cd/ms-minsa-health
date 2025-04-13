package com.jcarita.msminsahealth.controllers;

import com.jcarita.msminsahealth.model.HealthFacilitiesEntity;
import com.jcarita.msminsahealth.services.IHealthFacilitiesService;
import com.jcarita.msminsahealth.shared.response.ApiResponse;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/v1/minsa-health")
@RequiredArgsConstructor
public class MinsaHealthController {

    private final IHealthFacilitiesService healthFacilitiesService;

    @PostMapping("/seed")
    public ResponseEntity<ApiResponse<Map<String,Object>>> uploadData(@RequestParam("file")MultipartFile file) {

        if(file.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        Map<String, Object> data = new HashMap<>();
        data.put("count", 2);

        try (CSVReader reader = new CSVReader(new InputStreamReader(file.getInputStream()))) {
            String[] line;
            reader.readNext();
            int count = 0;
            while((line = reader.readNext()) != null && count < 3) {
                System.out.println(line[0]);
                count++;
            }
        }
        catch (CsvException |IOException e) {}

        return ResponseEntity.ok(
                ApiResponse.<Map<String, Object>>builder()
                        .message("Archivo subido")
                        .success(true)
                        .data(data)
                        .build()
        );

    }

//    GET   /api/v1/health-facilities	Obtener todos los establecimientos de salud.
    @GetMapping
    public ResponseEntity<ApiResponse<List<HealthFacilitiesEntity>>> getAll() {
        List<HealthFacilitiesEntity> healthFacilitiesEntities = healthFacilitiesService.getAll();
        return ResponseEntity.ok(
                ApiResponse.<List<HealthFacilitiesEntity>>builder()
                        .success(true)
                        .data(healthFacilitiesEntities)
                        .message("Successfully")
                        .build()
        );
    }
//    GET	/api/v1/health-facilities/{id}	Obtener un establecimiento por su ID (id_eess).
    @GetMapping(":/id")
    public ResponseEntity<ApiResponse<HealthFacilitiesEntity>> getById(@RequestParam("id") Long id) {
        Optional<HealthFacilitiesEntity> healthFacilities = healthFacilitiesService.findById(id);

        if(healthFacilities.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        ApiResponse<HealthFacilitiesEntity> data = ApiResponse.<HealthFacilitiesEntity>builder()
                .message("data successfully")
                .data(healthFacilities.get())
                .success(true)
                .build();

        return ResponseEntity.ok(data);
    }
//    GET	/api/v1/health-facilities/ubigeo/{ubigeo}	Listar establecimientos según el código UBIGEO.
    @GetMapping("/ubigeo/:ubigeo")
    public ResponseEntity<ApiResponse<List<HealthFacilitiesEntity>>> getByUbigeo(@RequestParam("ubigeo") String ubigeo) {
        List<HealthFacilitiesEntity> healthFacilities = healthFacilitiesService.getAllByUbigeo(ubigeo);

        ApiResponse<List<HealthFacilitiesEntity>> data = ApiResponse.<List<HealthFacilitiesEntity>>builder()
                .data(healthFacilities)
                .success(true)
                .message("request successfully")
                .build();

        return ResponseEntity.ok(data);
    }
//    GET	/api/v1/health-facilities/region/{diresa}	Listar establecimientos por nombre de región (diresa).
//    GET	/api/v1/health-facilities/red/{red}	Listar establecimientos por red de salud.
//    GET	/api/v1/health-facilities/category/{categoria}	Listar establecimientos por categoría (I-1, II-2, etc.).
//    GET	/api/v1/health-facilities/search?name={name}
}
